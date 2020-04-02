import java.util.HashMap;
import java.time.LocalDate;

public class DiningMenus {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        String endpoint = reqLib.configs.dining_menu;
        HashMap<String, Object> params = new HashMap<String, Object>();

        // Extract the date
        String[] date = LocalDate.now().toString().split("-");
        String year = date[0];
        String month = date[1];
        String day = date[2];

        // Let's choose lunch
        String[] possible_meals = {"Breakfast", "Lunch", "Dinner"};
        String meal = possible_meals[1];

        // Add the parameter
        params.put("locationID", 2);
        params.put(
            "menuID", 
            year + "-" + month + "-" + day + "-" + meal
        );

        try {
            String menu = reqLib.getRequest(endpoint, params);
            System.out.println(menu);
        } catch (Exception e) {
            throw new RuntimeException("Something went terribly wrong");
        }
    }
}