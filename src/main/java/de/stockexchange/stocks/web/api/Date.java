package de.stockexchange.stocks.web.api;

import java.time.LocalDate;

public class Date {
    private Long dateId;
    private LocalDate date;
    private LocalDate dateLastChanged;
    private Share share;

public Date(Long id, LocalDate date, LocalDate dateChange, Share share){
    this.dateId = id;
    this.date = date;
    this.dateLastChanged = dateChange;
    this.share = share;
}

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDateChange() {
        return dateLastChanged;
    }

    public void setDateChange(LocalDate dateChange) {
        this.dateLastChanged = dateChange;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }
}
