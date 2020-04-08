import java.util.HashMap;

/*
This API is pretty straightforward. This is 
the only endpoint that is within the API. It
returns a list of all of the departments within
Princeton University. Each item in the list 
is a dictionary with key "dept" whose value
is the name of the actual department.

This endpoint does not take any parameters.
*/

public class Department {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        String endpoint = reqLib.configs.department;
        HashMap<String, Object> params = new HashMap<String, Object>();
        
        try {
            String req = reqLib.getRequest(endpoint, params);
            System.out.println(req);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}