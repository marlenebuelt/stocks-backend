package de.stockexchange.stocks.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "shares")
public class SharesEntity {
    //    Spalten in der Tabelle
    @Id
    @Column(name = "wkn", nullable = false)
    private String wkn;
    @Column(name = "name")
    private String name;
    @Column(name = "stocksPrice")
    private double stocksPrice;
    @Column(name = "buy", nullable = false)
    private boolean buy;

    public SharesEntity(String wkn, String name, double stocksPrice, boolean buy) {
        this.wkn = wkn;
        this.name = name;
        this.stocksPrice = stocksPrice;
        this.buy = buy;
    }

    protected SharesEntity(){}

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
