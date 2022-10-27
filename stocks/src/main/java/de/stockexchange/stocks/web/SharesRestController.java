package de.stockexchange.stocks.web;

import de.stockexchange.stocks.web.api.Share;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SharesRestController {
    private List<Share> shares;

    public SharesRestController(){
        shares = new ArrayList<>();
        shares.add(new Share("865985", "Apple", 147.3, 83000000, 19400000, 0.8203, false));
        shares.add(new Share("A14Y6F", "Google", 94.41, 257488, 78565, 0.2996, true));
    }

    @GetMapping(path = "/api/v1/stocks")
    public ResponseEntity<List<Share>> fetchShares(){
        return ResponseEntity.ok(shares);
    }
}
