import java.io.FileInputStream;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/*
Prints information related to packages in
the Princeton University Art Museum's
collection.
*/

public class Packages {
    public static void main(String[] args) {
        try {
            ReqLib reqLib = new ReqLib();
            String package_name = "Chinese objects from December 2013 Asian Rotation";

            FileInputStream stream = new FileInputStream("packages.json");
            JsonReader jsonReader = Json.createReader(stream);
            JsonArray data = jsonReader.readArray();
            jsonReader.close();
            stream.close();

            int pkg_id = 0;
            for (int i = 0; i < data.size(); i++) {
                JsonObject pkg = data.getJsonObject(i);
                if (!pkg.isNull("packagenote") && pkg.getJsonString("packagenote").getString().equals(package_name)) {
                    pkg_id = pkg.getJsonNumber("PackageId").intValue();
                    break;
                }
            }

            String endpoint = reqLib.configs.packages + pkg_id;
            HashMap<String, Object> params = new HashMap<String, Object>();

            String packages = reqLib.makeRequest(endpoint, params);
            System.out.println(packages);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}