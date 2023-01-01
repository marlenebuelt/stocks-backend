package de.stockexchange.stocks.web.api;

import java.time.LocalDate;

public class Date {
    private Long dateId;
    private String date;
    private Share share;

public Date(Long id, String date, Share share){
    this.dateId = id;
    this.date = date;
    this.share = share;
}

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }
}
