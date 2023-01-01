package de.stockexchange.stocks.web.api;
public class DateManipulationRequest {
    private String date;
    private Long shareId;

public DateManipulationRequest(String date, Long shareId){
    this.date = date;
    this.shareId = shareId;
}
public DateManipulationRequest(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }
}


