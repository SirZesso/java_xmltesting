import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlType(name = "lieferschein", propOrder = { "lieferscheinNr", "lieferDatum", "kunde", "pos" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Lieferschein {

    @XmlAttribute(name = "nummer", required = true)
    private long lieferscheinNr;

    // https://stackoverflow.com/questions/36156741/marshalling-localdate-using-jaxb
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @XmlElement(name = "lieferdatum", required = true)
    private LocalDate lieferDatum;

    private Kunde kunde;

    @XmlElementWrapper(name = "positionen")
    @XmlElement(name = "position")
    private List<LieferscheinPosition> pos;

    public Lieferschein() {
    }

    public Lieferschein(long lieferscheinNr, LocalDate lieferDatum, Kunde kunde,
            List<LieferscheinPosition> positionen) {
        this.lieferscheinNr = lieferscheinNr;
        this.lieferDatum = lieferDatum;
        this.kunde = kunde;
        this.pos = positionen;
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
        return pos;
    }

    public void setPositionen(List<LieferscheinPosition> positionen) {
        this.pos = positionen;
    }

    @Override
    public String toString() {
        return "Lieferschein [kunde=" + kunde + ", lieferDatum=" + lieferDatum + ", lieferscheinNr=" + lieferscheinNr
                + ", positionen=" + pos + "]";
    }

}
