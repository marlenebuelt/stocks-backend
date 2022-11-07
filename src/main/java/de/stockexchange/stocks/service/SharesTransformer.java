package de.stockexchange.stocks.service;

import de.stockexchange.stocks.persistance.SharesEntity;
import de.stockexchange.stocks.web.api.Share;
import org.springframework.stereotype.Service;

@Service
public class SharesTransformer {
    public Share transformEntity(SharesEntity sharesEntity) {
        return new Share(
                sharesEntity.getId(),
                sharesEntity.getWkn(),
                sharesEntity.getName(),
                sharesEntity.getStocksPrice(),
                sharesEntity.isBuy());
    }
}
