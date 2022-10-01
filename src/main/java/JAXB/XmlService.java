package JAXB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class XmlService {
    public static void main(String[] args) throws JAXBException, IOException {
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

        // JAXB-Kontext erzeugen
        JAXBContext context = JAXBContext.newInstance(Lieferschein.class);

        // XML-Datei aus Objekt
        try (FileWriter fileWriter = new FileWriter("lieferschein.xml")) {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(lieferschein, fileWriter);
        }

        // Objekt aus XML-Datei
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Lieferschein p2 = (Lieferschein) unmarshaller.unmarshal(new File("lieferschein.xml"));
        System.out.println("Name aus Datei: " + p2.getLieferscheinNr());
    }
}