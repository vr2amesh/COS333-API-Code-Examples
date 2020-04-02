import java.util.HashMap;

/*
This will print the information of the 
current term. Each term has the following
parameters:

code (The id number of the term according to the Registrar)
suffix (Formatted version of the term as such: TermYear [e.g. S2020, F2019, F2018, etc.])
name (Formatted term as such: [e.g. S19-20, F19-20, F18-19, etc.])
cal_name (Formatted term as such: Term Year [e.g. Spring 2020, Fall 2019, Fall 2018, etc.])
reg_name (Formatted term as such: Years Term [e.g. 19-20 Spr, 19-20 Fall, 18-19 Fall, etc.])
start_date (start date formatted YYYY-MM-DD)
end_date (end date formatted YYYY-MM-DD)
*/

public class CoursesTerms {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        String endpoint = reqLib.configs.course_terms;
        HashMap<String, Object> params = new HashMap<String, Object>();
        // Need these to convert the response into json
        params.put("fmt", "json");
        
        try {
            String term_info = reqLib.getRequest(endpoint, params);
            System.out.println(term_info);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}