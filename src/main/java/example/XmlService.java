package example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class XmlService {
    public static void main(String[] args) throws JAXBException, IOException {
        Person p = new Person();
        p.setVorname("Vreni");
        p.setNachname("Meister");

        // JAXB-Kontext erzeugen
        JAXBContext context = JAXBContext.newInstance(Person.class);

        // XML-Datei aus Objekt
        try (FileWriter fileWriter = new FileWriter("person.xml")) {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(p, fileWriter);
        }

        // Objekt aus XML-Datei
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Person p2 = (Person) unmarshaller.unmarshal(new File("person.xml"));
        System.out.println("Name aus Datei: " + p2.getNachname());
    }
}