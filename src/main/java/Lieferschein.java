import java.time.LocalDate;
import java.util.List;

public class Lieferschein {
    private long lieferscheinNr;
    private LocalDate lieferDatum;
    private Kunde kunde;
    private List<LieferscheinPosition> positionen;

    public Lieferschein(long lieferscheinNr, LocalDate lieferDatum, Kunde kunde,
            List<LieferscheinPosition> positionen) {
        this.lieferscheinNr = lieferscheinNr;
        this.lieferDatum = lieferDatum;
        this.kunde = kunde;
        this.positionen = positionen;
    }

    public long getLieferscheinNr() {
        return lieferscheinNr;
    }

    public void setLieferscheinNr(long lieferscheinNr) {
        this.lieferscheinNr = lieferscheinNr;
    }

    public LocalDate getLieferDatum() {
        return lieferDatum;
    }

    public void setLieferDatum(LocalDate lieferDatum) {
        this.lieferDatum = lieferDatum;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public List<LieferscheinPosition> getPositionen() {
        return positionen;
    }

    public void setPositionen(List<LieferscheinPosition> positionen) {
        this.positionen = positionen;
    }

    @Override
    public String toString() {
        return "Lieferschein [kunde=" + kunde + ", lieferDatum=" + lieferDatum + ", lieferscheinNr=" + lieferscheinNr
                + ", positionen=" + positionen + "]";
    }

}
