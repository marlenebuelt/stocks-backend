package de.stockexchange.stocks.persistance;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "shares")
public class SharesEntity {
    //Spalten in der Tabelle
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "wkn")
    private String wkn;
    @Column(name = "name")
    private String name;
    @Column(name = "stocksPrice")
    private BigDecimal stocksPrice;
    @Column(name = "buy")
    private boolean buy;

    /*@OneToMany(mappedBy = "date", fetch = FetchType.EAGER)
    private List<DateEntity> date = new ArrayList<>();*/

    @OneToMany(mappedBy = "date", fetch = FetchType.EAGER)
    private List<DateEntity> date = new ArrayList<>();*/

    public SharesEntity(String wkn, String name, BigDecimal stocksPrice, boolean buy) {
        this.wkn = wkn;
        this.name = name;
        this.stocksPrice = stocksPrice;
        this.buy = buy;
    }

    protected SharesEntity(){}

    public long getId() {
        return id;
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

    /*public List<DateEntity> getDate() {
=======
    public List<DateEntity> getDate() {
>>>>>>> c023f955bd521f172914a86505573e12ac46655c
        return date;
    }

    public void setDate(List<DateEntity> date) {
        this.date = date;
<<<<<<< HEAD
    }*/
