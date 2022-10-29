package de.stockexchange.stocks;

import de.stockexchange.stocks.persistance.SharesEntity;
import de.stockexchange.stocks.persistance.SharesRepository;
import de.stockexchange.stocks.web.api.Share;
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
        return shares.stream().map(sharesEntity ->
                new Share(sharesEntity.getWkn(), sharesEntity.getName(), sharesEntity.getStocksPrice(), sharesEntity.isBuy())).collect(Collectors.toList());
    }
}
