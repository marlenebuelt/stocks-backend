package de.stockexchange.stocks.service;

import de.stockexchange.stocks.persistance.DateEntity;
import de.stockexchange.stocks.persistance.DateRepository;
import de.stockexchange.stocks.persistance.SharesRepository;
import de.stockexchange.stocks.web.api.Date;
import de.stockexchange.stocks.web.api.DateManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DateService {
    private final SharesRepository sharesRepository;
    private final DateRepository dateRepository;
    private final SharesTransformer sharesTransformer;

    public DateService (SharesRepository sharesRepository, DateRepository dateRepository, SharesTransformer sharesTransformer){
        this.sharesRepository = sharesRepository;
        this.dateRepository = dateRepository;
        this.sharesTransformer = sharesTransformer;
    }
    public List<Date> findAll(){
        List <DateEntity> dates = dateRepository.findAll();
        return dates.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Date create (DateManipulationRequest dmr){
        var date = dmr.getDate();
        var dateLastChanged = dmr.getDateLastChanged();
        var share = sharesRepository.findById(dmr.getShareId()).orElseThrow();
        var dateEntity = new DateEntity(date, dateLastChanged, share);
        dateEntity = dateRepository.save(dateEntity);
        return transformEntity(dateEntity);
    }

    public Date transformEntity(DateEntity dateEntity){
        return new Date(dateEntity.getDateId(), dateEntity.getDate(), dateEntity.getDateLastChanged(), sharesTransformer.transformEntity(dateEntity.getShare()));
    }
}
