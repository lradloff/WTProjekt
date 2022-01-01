package htw.berlin.webtech.WTProjekt.web.api;

public class Rechnung {

    private Long id;
    private String rechnung;
    private String datum;
    private String ergebnis;

    public Rechnung(Long id, String rechnung, String datum, String ergebnis){
        this.id = id;
        this.rechnung = rechnung;
        this.datum = datum;
        this.ergebnis = ergebnis;
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

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(String ergebnis) {
        this.ergebnis = ergebnis;
    }
}
