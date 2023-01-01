package de.stockexchange.stocks.web;

import de.stockexchange.stocks.service.DateService;
import de.stockexchange.stocks.web.api.Date;
import de.stockexchange.stocks.web.api.DateManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@RestController
public class DateRestController {
    private final DateService dateService;
    public DateRestController(DateService dateService){
        this.dateService = dateService;
    }

    @GetMapping(path="/api/v1/dates")
    public ResponseEntity<List<Date>> fetchDate(){
        return ResponseEntity.ok(dateService.findAll());
    }

    @PostMapping(path="/api/v1/dates")
    public ResponseEntity<Void> createDate(@RequestBody DateManipulationRequest dmr) throws URISyntaxException{
        Date date = dateService.create(dmr);
        URI uri = new URI("/api/v1/dates"+date.getDateId());
        return ResponseEntity.created(uri).build();
    }
}
