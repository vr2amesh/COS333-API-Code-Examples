import java.util.HashMap;

/*
This endpoint returns information about
a user within the Princeton community.
The only parameter that the endpoint requires
is the user's netid. The parameter's name is:

uid

The return value has the following information
about the user:

displayname (Full name of the user)
universityid (PUID number)
mail (user's email address)
pustatus (is the user a graduate, undergraduate, or faculty?)
department (which department the user belongs to)
eduPersonPrimaryAffiliation (whether the user is a student or faculty)
streetAddress (office number and location if it is a faculty member)
telephoneNumber (phone number if it is a faculty member)
*/

public class Users {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        String endpoint = reqLib.configs.users;
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("uid", "rdondero");
        
        try {
            String req = reqLib.getRequest(endpoint, params);
            System.out.println(req);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}