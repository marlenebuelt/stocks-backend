package de.stockexchange.stocks.web.api;

import java.math.BigDecimal;

public class ShareManipulationRequest {
    private String wkn;
    private String name;
    private BigDecimal stocksPrice;
    private boolean buy;


    public ShareManipulationRequest(String wkn, String name, BigDecimal stocksPrice, boolean buy) {
        this.wkn = wkn;
        this.name = name;
        this.stocksPrice = stocksPrice;
        this.buy = buy;
    }


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
