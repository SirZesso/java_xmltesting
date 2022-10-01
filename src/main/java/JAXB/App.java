package JAXB;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

public class App {

    public static void main(String[] args) {

        final List<Artikel> artikelListe = new ArrayList<Artikel>();
        artikelListe.add(new Artikel(1, "Badeschaum"));
        artikelListe.add(new Artikel(2, "Schwimmente"));
        artikelListe.add(new Artikel(3, "Saugnapf"));
        artikelListe.add(new Artikel(4, "Bluetooth Duschbrause"));

        final Kunde kunde = new Kunde(118, "Yannic Ziegler", "Hessostrasse 12", "2540", "Grenchen");

        final List<LieferscheinPosition> positionen = new ArrayList<LieferscheinPosition>();
        positionen.add(new LieferscheinPosition(2, 2));
        positionen.add(new LieferscheinPosition(100, 4));

        final Lieferschein lieferschein = new Lieferschein(1, LocalDate.of(2000, 12, 3), kunde, positionen);

        System.out.println(lieferschein);
    }
}
