import java.util.HashMap;

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
            throw new RuntimeException("Something went terribly wrong");
        }
    }
}