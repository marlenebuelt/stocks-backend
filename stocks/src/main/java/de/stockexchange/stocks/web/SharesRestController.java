package de.stockexchange.stocks.web;

import de.stockexchange.stocks.SharesService;
import de.stockexchange.stocks.web.api.Share;
import de.stockexchange.stocks.web.api.ShareCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping(path = "/api/v1/shares")
    public ResponseEntity<Void> createShare(@RequestBody ShareCreateRequest request) throws URISyntaxException {
        var share = sharesService.create(request);
        URI uri = new URI("/api/v1/shares/" + share.getWkn());
        return ResponseEntity.created(uri).build();
    }
}
