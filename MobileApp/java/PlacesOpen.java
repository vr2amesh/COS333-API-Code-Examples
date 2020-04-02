import java.util.HashMap;

/*
This will print out the information
of the place. Each place has the 
following parameters:

name (name of the place)
id (unique id number of the place)
open (indicates whether or not the place is open. Not a boolean, is a text "yes" or "no")
*/

public class PlacesOpen {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        String endpoint = reqLib.configs.places_open;
        HashMap<String, Object> params = new HashMap<String, Object>();

        params.put("fmt", "json");
        
        try {
            String places = reqLib.getRequest(endpoint, params);
            System.out.println(places);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}