package htw.berlin.webtech.WTProjekt.persistence;

import javax.persistence.*;

@Entity(name = "rechnungen")
public class RechnungEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rechnung", nullable = false)
    private String rechnung;

    @Column(name = "datum")
    private String datum;

    @Column(name = "ergebnis")
    private String ergebnis;

    public RechnungEntity(String rechnung, String datum, String ergebnis) {
        this.rechnung = rechnung;
        this.datum = datum;
        this.ergebnis = ergebnis;
    }

    protected RechnungEntity() {
    }

    public Long getId() {
        return id;
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
