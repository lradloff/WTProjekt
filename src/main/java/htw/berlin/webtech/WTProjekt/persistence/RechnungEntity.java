package htw.berlin.webtech.WTProjekt.persistence;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "rechnungen")
public class RechnungEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rechnung", nullable = false)
    private String rechnung;

    @Column(name = "datum")
    private LocalDate datum;

    @Column(name = "ergebnis")
    private Long ergebnis;

    public RechnungEntity(String rechnung, LocalDate datum, Long ergebnis) {
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
