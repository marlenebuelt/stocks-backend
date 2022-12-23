package de.stockexchange.stocks.web.api;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ShareManipulationRequest {
    @NotBlank(message="Please add a value")
    private String wkn;
    @NotBlank(message="Please add a value")
    private String name;
    //@NotBlank(message="Please add a value")
    @Positive(message = "Value must be positive")
    private BigDecimal stocksPrice;
    private boolean buy;

    public ShareManipulationRequest(String wkn, String name, BigDecimal stocksPrice, boolean buy) {
        this.wkn = wkn;
        this.name = name;
        this.stocksPrice = stocksPrice;
        this.buy = buy;
    }

    public ShareManipulationRequest(){}
    public String getWkn() {
        return wkn;
    }

    public void setWkn(String wkn) {
        this.wkn = wkn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getStocksPrice() {
        return stocksPrice;
    }

    public void setStocksPrice(BigDecimal stocksPrice) {
        this.stocksPrice = stocksPrice;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }
}
