package de.stockexchange.stocks.web.api;

import java.time.LocalDate;

public class DateManipulationRequest {
    private LocalDate date;
    private LocalDate dateLastChanged;
    private Long shareId;

public DateManipulationRequest(LocalDate dateId, LocalDate date, Long shareId){
    this.date = dateId;
    this.dateLastChanged = date;
    this.shareId = shareId;
}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDateLastChanged() {
        return dateLastChanged;
    }

    public void setDateLastChanged(LocalDate dateLastChanged) {
        this.dateLastChanged = dateLastChanged;
    }

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }
}


