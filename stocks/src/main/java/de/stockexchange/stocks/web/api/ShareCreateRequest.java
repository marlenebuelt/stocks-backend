package de.stockexchange.stocks.web.api;

public class ShareCreateRequest {
    private String wkn;
    private String name;
    private double stocksPrice;
    private boolean buy;


    public ShareCreateRequest(String wkn, String name, double stocksPrice, boolean buy) {
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

    public double getStocksPrice() {
        return stocksPrice;
    }

    public void setStocksPrice(double stocksPrice) {
        this.stocksPrice = stocksPrice;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }
}
