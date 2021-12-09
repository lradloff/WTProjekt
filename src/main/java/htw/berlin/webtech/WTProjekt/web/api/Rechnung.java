package htw.berlin.webtech.WTProjekt.web.api;

import java.time.LocalDate;
import java.util.Date;

public class Rechnung {

    private Long id;
    private String rechnung;
    private LocalDate datum;
    private Long ergebnis;

    public Rechnung(Long id, String rechnung, LocalDate datum){
        this.id = id;
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
