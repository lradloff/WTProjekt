package htw.berlin.webtech.WTProjekt.web.api;

public class RechnungManipulationRequest {

    private String rechnung;
    private String datum;
    private String ergebnis;

    public RechnungManipulationRequest(String rechnung, String datum, String ergebnis) {
        this.rechnung = rechnung;
        this.datum = datum;
        this.ergebnis = ergebnis;
    }

    public RechnungManipulationRequest() {
    }

    public String getRechnung() {
        return rechnung;
    }

    public void setRechnung(String rechnung) {
        this.rechnung = rechnung;
    }

    public String getDatum(){
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
