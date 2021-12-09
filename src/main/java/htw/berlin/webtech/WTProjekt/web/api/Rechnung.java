package htw.berlin.webtech.WTProjekt.web.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Rechnung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rechnung;
    private LocalDate datum;
    private Long ergebnis;

    public Rechnung(){}

    public Rechnung(String rechnung, LocalDate datum){
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

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Long getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(Long ergebnis) {
        this.ergebnis = ergebnis;
    }
}
