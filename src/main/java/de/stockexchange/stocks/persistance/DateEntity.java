package de.stockexchange.stocks.persistance;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="date")
public class DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long dateId;

    @Column(name="date")
    private String date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "share_id", referencedColumnName = "id")
    private SharesEntity share;

    public DateEntity(String date, SharesEntity share) {
        this.date = date;
        this.share = share;
    }

    public DateEntity() {
    }

    public Long getDateId() {
        return dateId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SharesEntity getShare() {
        return share;
    }

    public void setShare(SharesEntity share) {
        this.share = share;
    }
}
