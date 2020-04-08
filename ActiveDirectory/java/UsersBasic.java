import java.util.HashMap;

/*
This endpoint returns information about
a user within the Princeton community.
This endpoint provides
a bit less information than does the 
endpoint in the file users.py.
The only parameter that the endpoint requires
is the user's netid. The parameter's name is:

uid

The return value has the following information
about the user:

displayname (Full name of the user)
universityid (PUID number)
mail (user's email address)
*/

public class UsersBasic {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        String endpoint = reqLib.configs.users_basic;
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