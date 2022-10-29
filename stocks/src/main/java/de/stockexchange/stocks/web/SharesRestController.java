package de.stockexchange.stocks.web;

import de.stockexchange.stocks.SharesService;
import de.stockexchange.stocks.web.api.Share;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
