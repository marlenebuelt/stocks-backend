package de.stockexchange.stocks;

import de.stockexchange.stocks.persistance.SharesEntity;
import de.stockexchange.stocks.persistance.SharesRepository;
import de.stockexchange.stocks.web.api.Share;
import de.stockexchange.stocks.web.api.ShareCreateRequest;
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
    public Share create(ShareCreateRequest request){
        var sharesEntity = new SharesEntity(request.getWkn(), request.getName(), request.getStocksPrice(), request.isBuy());
        sharesEntity = sharesRepository.save(sharesEntity);
        return transformEntity(sharesEntity);
    }

    private Share transformEntity(SharesEntity sharesEntity){
        return new Share(sharesEntity.getWkn(), sharesEntity.getName(), sharesEntity.getStocksPrice(), sharesEntity.isBuy());
    }
}
