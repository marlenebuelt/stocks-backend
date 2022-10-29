package de.stockexchange.stocks;

import de.stockexchange.stocks.persistance.SharesEntity;
import de.stockexchange.stocks.persistance.SharesRepository;
import de.stockexchange.stocks.web.api.Share;
import de.stockexchange.stocks.web.api.ShareManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SharesService {
    private final SharesRepository sharesRepository;

    public SharesService(SharesRepository sharesRepository){
        this.sharesRepository = sharesRepository;
    }
    public List<Share> findAll(){
        List<SharesEntity> shares = sharesRepository.findAll();
        return shares.stream().map(this::transformEntity).collect(Collectors.toList());
    }
    public Share findByWkn(String wkn){
        var shareEntity = sharesRepository.findById(Long.valueOf(wkn));
        return shareEntity.map(this::transformEntity).orElse(null);
    }
    public Share create(ShareManipulationRequest request){
        var sharesEntity = new SharesEntity(request.getWkn(), request.getName(), request.getStocksPrice(), request.isBuy());
        sharesEntity = sharesRepository.save(sharesEntity);
        return transformEntity(sharesEntity);
    }
    public Share update(String wkn, ShareManipulationRequest request){
        var shareEntityOptional = sharesRepository.findById(Long.valueOf(wkn));
        if(shareEntityOptional.isEmpty()){
            return null;
        }
        var shareEntity = shareEntityOptional.get();
        shareEntity.setName(request.getName());
        shareEntity.setStocksPrice(request.getStocksPrice());
        shareEntity.setBuy(request.isBuy());
        shareEntity = sharesRepository.save(shareEntity);
        return transformEntity(shareEntity);
    }
    public boolean deleteByWkn(String wkn){
        if(!sharesRepository.existsById(Long.valueOf(wkn))){
            return false;
        }
        sharesRepository.deleteById(Long.valueOf(wkn));
        return true;
    }


    private Share transformEntity(SharesEntity sharesEntity){
        return new Share(sharesEntity.getWkn(), sharesEntity.getName(), sharesEntity.getStocksPrice(), sharesEntity.isBuy());
    }
}
