import java.io.FileInputStream;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/*
Prints information related to objects in
the Princeton University Art Museum's
collection.
*/

public class Objects {
    public static void main(String[] args) {
        try {
            ReqLib reqLib = new ReqLib();
            String object_name = "Figure Emerging from Clouds";

            FileInputStream stream = new FileInputStream("objects.json");
            JsonReader jsonReader = Json.createReader(stream);
            JsonArray data = jsonReader.readArray();
            jsonReader.close();
            stream.close();

            int object_id = 0;
            for (int i = 0; i < data.size(); i++) {
                JsonObject obj = data.getJsonObject(i);
                if (!obj.isNull("displaytitle") && obj.getJsonString("displaytitle").getString().equals(object_name)) {
                    object_id = obj.getJsonNumber("ObjectID").intValue();
                    break;
                }
            }

            String endpoint = reqLib.configs.objects + object_id;
            HashMap<String, Object> params = new HashMap<String, Object>();

            String objects = reqLib.makeRequest(endpoint, params);
            System.out.println(objects);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}