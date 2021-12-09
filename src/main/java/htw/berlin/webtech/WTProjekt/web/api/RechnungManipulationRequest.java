package htw.berlin.webtech.WTProjekt.web.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Date;

public class RechnungManipulationRequest {

    private String rechnung;
    private LocalDate datum;
    private Long ergebnis;

    public RechnungManipulationRequest(String rechnung, LocalDate datum) {
        this.rechnung = rechnung;
        this.datum = datum;
    }

    public RechnungManipulationRequest() {
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
