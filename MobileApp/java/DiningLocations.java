import java.util.HashMap;

/*
This route does not return data back in a JSON
format, rather it returns in an XML format. Therefore,
if you wish to access this data in JSON form, you will
need to do some manual parsing.

This route returns dining locations along with 
its latitude/longitude information, payment options,
building name, etc.

some categories:

2: dining halls
3: cafes
4: vending machines
6: shows amenities of each hall on campus. 
   Printers, Mac clusters, scanners, and wheelchair
   accessibility.

Please explore the rest of the category ids in order to see
which ones may fit your application needs.

Parameter: categoryID
*/

public class DiningLocations {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        String endpoint = reqLib.configs.dining_locations;
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("categoryID", 2);
        
        try {
            String locations = reqLib.getRequest(endpoint, params);
            System.out.println(locations);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}