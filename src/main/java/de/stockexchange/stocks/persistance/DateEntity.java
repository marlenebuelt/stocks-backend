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
    private LocalDate date;

    @Column
    private LocalDate dateLastChanged;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "share_id", referencedColumnName = "id")
    private SharesEntity share;

    public DateEntity(LocalDate date, LocalDate dateLastChanged, SharesEntity share) {
        this.date = date;
        this.dateLastChanged = dateLastChanged;
        this.share = share;
    }

    public DateEntity() {
    }

    public Long getDateId() {
        return dateId;
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

    public void setDateLastChanged(LocalDate dateChange) {
        this.dateLastChanged = dateChange;
    }

    public SharesEntity getShare() {
        return share;
    }

    public void setShare(SharesEntity share) {
        this.share = share;
    }
}
