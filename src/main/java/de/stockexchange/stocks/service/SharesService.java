package de.stockexchange.stocks.service;

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
    private final SharesTransformer sharesTransformer;
    public SharesService(SharesRepository sharesRepository, SharesTransformer sharesTransformer) {
        this.sharesRepository = sharesRepository;
        this.sharesTransformer = sharesTransformer;
    }

    public List<Share> findAll() {
        List<SharesEntity> shares = sharesRepository.findAll();
        return shares.stream()
                .map(sharesTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Share findById(long id) {
        var shareEntity = sharesRepository.findById(id);
        return shareEntity.map(sharesTransformer::transformEntity).orElse(null);
    }

    public Share create(ShareManipulationRequest request) {
        var sharesEntity = new SharesEntity(request.getWkn(), request.getName(), request.getStocksPrice(), request.isBuy());
        sharesEntity = sharesRepository.save(sharesEntity);
        return sharesTransformer.transformEntity(sharesEntity);
    }

    public Share update(long id, ShareManipulationRequest request) {
        var shareEntityOptional = sharesRepository.findById(id);
        if (shareEntityOptional.isEmpty()) {
            return null;
        }
        var shareEntity = shareEntityOptional.get();
        shareEntity.setName(request.getName());
        shareEntity.setStocksPrice(request.getStocksPrice());
        shareEntity.setBuy(request.isBuy());
        shareEntity = sharesRepository.save(shareEntity);
        return sharesTransformer.transformEntity(shareEntity);
    }

    public boolean deleteById(long id) {
        if (!sharesRepository.existsById(id)) {
            return false;
        }
        sharesRepository.deleteById(id);
        return true;
    }
}
