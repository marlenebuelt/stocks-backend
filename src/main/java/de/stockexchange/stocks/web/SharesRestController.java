package de.stockexchange.stocks.web;

import de.stockexchange.stocks.service.SharesService;
import de.stockexchange.stocks.web.api.Share;
import de.stockexchange.stocks.web.api.ShareManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping(path = "/api/v1/shares/{id}")
    public ResponseEntity<Share> fetchPersonById(@PathVariable long id){
        var share = sharesService.findById(id);
        return share != null? ResponseEntity.ok(share): ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/shares")
    public ResponseEntity<Void> createShare(@Valid @RequestBody ShareManipulationRequest request) throws URISyntaxException {
        var share = sharesService.create(request);
        URI uri = new URI("/api/v1/shares/" + share.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path ="/api/v1/shares/{id}")
    public ResponseEntity<Share> updateShare(@PathVariable long id, @RequestBody ShareManipulationRequest request){
        var share = sharesService.update(id, request);
        return share != null? ResponseEntity.ok(share): ResponseEntity.notFound().build();
    }
    @DeleteMapping(path ="/api/v1/shares/{id}")
    public ResponseEntity<Share> deleteShare(@PathVariable long id){
        boolean successful = sharesService.deleteById(id);
        return successful ? ResponseEntity.ok().build(): ResponseEntity.notFound().build();
    }
}
