package JAXB;

public class LieferscheinPosition {

    private int menge;
    private int artikelNr;

    public LieferscheinPosition(int menge, int artikelNr) {
        this.artikelNr = artikelNr;
        this.menge = menge;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public int getArtikelNr() {
        return artikelNr;
    }

    public void setArtikelNr(int artikelNr) {
        this.artikelNr = artikelNr;
    }

    @Override
    public String toString() {
        return "LieferscheinPosition [artikelNr=" + artikelNr + ", menge=" + menge + "]";
    }
}
