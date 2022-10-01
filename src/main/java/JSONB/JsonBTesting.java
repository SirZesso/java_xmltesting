package JSONB;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;

public class JsonBTesting {
    public static void main(String[] args) throws JsonbException, IOException {
        Person person = new Person();
        person.setVorname("Jason");
        person.setNachname("Meyer");

        // Jsonb Kontext
        Jsonb jsonb = JsonbBuilder.create();

        // Java-Objekt nach json-String
        System.out.println("Java-Objekt nach json-String:");
        String jsonPersonString = jsonb.toJson(person);
        System.out.println(jsonPersonString);

        // Java-Objekt nach json-Datei
        try (FileWriter fileWriter = new FileWriter("person.json")) {
            jsonb.toJson(person, fileWriter);
        }

        // json-String nach Java-Objekt
        Person personFromString = jsonb.fromJson(jsonPersonString, Person.class);
        System.out.println("Vorname from json-String: " + personFromString.getVorname());

        // json-Datei nach Java-Objekt
        Person personFromFile = jsonb.fromJson(new FileReader("person.json"), Person.class);
        System.out.println("Vorname from json-File: " + personFromFile.getVorname());
    }

}
