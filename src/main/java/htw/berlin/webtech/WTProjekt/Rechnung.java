package htw.berlin.webtech.WTProjekt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Rechnung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rechnung;
    private Date datum;
    private Long ergebnis;

    public Rechnung(){}

    public Rechnung(String rechnung, Date datum){
        this.rechnung = rechnung;
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRechnung() {
        return rechnung;
    }

    public void setRechnung(String rechnung) {
        this.rechnung = rechnung;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Long getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(Long ergebnis) {
        this.ergebnis = ergebnis;
    }
}
