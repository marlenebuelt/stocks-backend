package de.stockexchange.stocks.web;

import de.stockexchange.stocks.SharesService;
import de.stockexchange.stocks.web.api.Share;
import de.stockexchange.stocks.web.api.ShareManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class SharesRestController {
    private final SharesService sharesService;

    public SharesRestController(SharesService sharesService) {
        this.sharesService = sharesService;
    }
    @GetMapping(path = "/api/v1/shares")
    public ResponseEntity<List<Share>> fetchShares(){
        return ResponseEntity.ok(sharesService.findAll());
    }
    @GetMapping(path = "/api/v1/shares/{wkn}")
    public ResponseEntity<Share> fetchPersonByWkn(@PathVariable String wkn){
        var share = sharesService.findByWkn(wkn);
        return share != null? ResponseEntity.ok(share): ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/shares")
    public ResponseEntity<Void> createShare(@RequestBody ShareManipulationRequest request) throws URISyntaxException {
        var share = sharesService.create(request);
        URI uri = new URI("/api/v1/shares/" + share.getWkn());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path ="/api/v1/shares/{wkn}")
    public ResponseEntity<Share> updateShare(@PathVariable String wkn, @RequestBody ShareManipulationRequest request){
        var share = sharesService.update(wkn, request);
        return share != null? ResponseEntity.ok(share): ResponseEntity.notFound().build();
    }
    @DeleteMapping(path ="/api/v1/shares/{wkn}")
    public ResponseEntity<Share> deleteShare(@PathVariable String wkn){
        boolean successful = sharesService.deleteByWkn(wkn);
        return successful ? ResponseEntity.ok().build(): ResponseEntity.notFound().build();
    }
}
