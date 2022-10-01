package jsonBsp;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

public class JsonVorzeige {

    public static void main(String[] args) throws IOException {
        // Json Erstellen
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("name", "Yannic")
                .add("alter", 30)
                .add("aktiv", Boolean.FALSE).build();

        // Als String ausgeben
        String jsonString = jsonObject.toString();
        System.out.println("Neues Json-Object:");
        System.out.println(jsonString);

        // Als Datei ausgeben
        try (FileWriter fileWriter = new FileWriter("json-test.json")) {
            Json.createWriter(fileWriter).writeObject(jsonObject);
        }

        // Json aus String Lesen
        JsonReader jsonStringReader = Json.createReader(new StringReader(jsonString));
        JsonObject jsonObject1 = jsonStringReader.readObject();
        System.out.println("\nJson-Objekt aus String gelesen:");
        System.out.println(jsonObject1);

        // Json aus Datei Lesen
        JsonReader jsonReader = Json.createReader(new FileReader("json-test.json"));
        JsonObject jsonObject2 = jsonReader.readObject();
        System.out.println("\nJson-Objekt aus File gelesen:");
        System.out.println(jsonObject2);

        // Auf Werte Zugreifen
        var name = jsonObject2.getString("name");
        System.out.println("Name aus Json: " + name);
    }

}
