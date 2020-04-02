import java.util.HashMap;

/*
This endpoint on the MobileApp API returns 
an iCal stream of dining venue open hours.
The iCal stream really is just a plain 
text stream.

Parameter: placeID


Experiment with different placeID values
to learn
*/

public class DiningEvents {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        String endpoint = reqLib.configs.dining_events;
        HashMap<String, Object> params = new HashMap<String, Object>();

        params.put("placeID", 1);
        
        try {
            String events = reqLib.getRequest(endpoint, params);
            System.out.println(events);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}