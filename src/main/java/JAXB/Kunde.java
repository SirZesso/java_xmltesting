package JAXB;

public class Kunde {
    private long kundeNr;
    private String name;
    private String adresse;
    private String plz;
    private String ort;

    public Kunde(long kundeNr, String name, String adresse, String plz, String ort) {
        this.kundeNr = kundeNr;
        this.name = name;
        this.adresse = adresse;
        this.plz = plz;
        this.ort = ort;
    }

    public long getKundeNr() {
        return kundeNr;
    }

    public void setKundeNr(long kundeNr) {
        this.kundeNr = kundeNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "Kunde [adresse=" + adresse + ", kundeNr=" + kundeNr + ", name=" + name + ", ort=" + ort + ", plz=" + plz
                + "]";
    }
}
