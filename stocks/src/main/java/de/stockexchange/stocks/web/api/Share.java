package de.stockexchange.stocks.web.api;

public class Share {

    private String wkn;
    private String name;
    private double stocksPrice;
    private double revenue;
    private double costs;
    private double liabilitiesToEquity;
    private boolean buy;

    public Share(String wkn, String name, double stocksPrice, float companyTurnover, float costs, double liabilitiesToEquity, boolean buy) {
        this.wkn = wkn;
        this.name = name;
        this.stocksPrice = stocksPrice;
        this.revenue = companyTurnover;
        this.costs = costs;
        this.liabilitiesToEquity = liabilitiesToEquity;
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

    public void setStocksPrice(float stocksPrice) {
        this.stocksPrice = stocksPrice;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(float costs) {
        this.costs = costs;
    }

    public double getLiabilitiesToEquity() {
        return liabilitiesToEquity;
    }

    public void setLiabilitiesToEquity(float liabilitiesToEquity) {
        this.liabilitiesToEquity = liabilitiesToEquity;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }
}
