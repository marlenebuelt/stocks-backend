package de.stockexchange.stocks.web.api;

import java.math.BigDecimal;

public class Share {
    private long id;
    private String wkn;
    private String name;
    private BigDecimal stocksPrice;
    private boolean buy;

    public Share(long id, String wkn, String name, BigDecimal stocksPrice, boolean buy) {
        this.id = id;
        this.wkn = wkn;
        this.name = name;
        this.stocksPrice = stocksPrice;
        this.buy = buy;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
