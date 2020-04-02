import java.util.HashMap;
import java.time.LocalDate;

/*
This endpoint on the MobileApp API returns 
an iCal stream of dining venue open hours.
The iCal stream really is just a plain 
text stream.

Parameters: from, to

The from and to parameters are dates formatted
in the following way:

YYYYMMDD

*/

public class EventsEvents {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        String endpoint = reqLib.configs.events_events;
        HashMap<String, Object> params = new HashMap<String, Object>();

        // Extract the date
        String[] date = LocalDate.now().toString().split("-");
        String year = date[0];
        String month = date[1];
        String day = date[2];

        // Calculate the date two days from now
        String[] two_days_later = LocalDate.now().plusDays(2).toString().split("-");
        String new_year = two_days_later[0];
        String new_month = two_days_later[1];
        String new_day = two_days_later[2];

        params.put("from", year + month + day);
        params.put("to", new_year + new_month + new_day);
        
        try {
            String events = reqLib.getRequest(endpoint, params);
            System.out.println(events);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}