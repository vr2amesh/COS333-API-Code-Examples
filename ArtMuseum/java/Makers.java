import java.io.FileInputStream;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/*
Prints information related to makers in
the Princeton University Art Museum's
collection.
*/

public class Makers {
    public static void main(String[] args) {
        try {
            ReqLib reqLib = new ReqLib();
            String maker_name = "Pablo Picasso";

            FileInputStream stream = new FileInputStream("makers.json");
            JsonReader jsonReader = Json.createReader(stream);
            JsonArray data = jsonReader.readArray();
            jsonReader.close();
            stream.close();

            int maker_id = 0;
            for (int i = 0; i < data.size(); i++) {
                JsonObject m = data.getJsonObject(i);
                if (m.getJsonString("displayname").getString().equals(maker_name)) {
                    maker_id = m.getJsonNumber("ConstituentID").intValue();
                    break;
                }
            }

            String endpoint = reqLib.configs.makers + maker_id;
            HashMap<String, Object> params = new HashMap<String, Object>();

            String makers = reqLib.makeRequest(endpoint, params);
            System.out.println(makers);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}