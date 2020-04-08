import java.util.HashMap;
import java.time.LocalDate;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

/*
This endpoint returns all users that belong
to a particular group on campus. By using
the endpoint in the file users_full.py,
you can see which groups a particular user
is a part of. The correct name of the group
will be necessary when using this endpoint.
The only parameter of this endpoint is the 
following:

name (name of the group)

In this example, we will return everyone in
the current year's undergraduate class.
*/

public class Groups {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        String endpoint = reqLib.configs.groups;
        HashMap<String, Object> params = new HashMap<String, Object>();
        
        // Extract the date
        String[] date = LocalDate.now().toString().split("-");
        String year = date[0];
        String value;
        // It is very important to url encode this string, because it has
        // spaces in it. In python, this is automatically done, but in
        // java this is not the case.
        try {
            value = URLEncoder.encode("Undergraduate Class of " + year, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        params.put("name", value);

        try {
            String req = reqLib.getRequest(endpoint, params);
            System.out.println(req);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}