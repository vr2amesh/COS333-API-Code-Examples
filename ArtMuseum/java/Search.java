import java.util.HashMap;

/*
One can use this search endpoint in
order to search for objects according 
to their type among other things. 
The parameters are as follows:

q: query string
type: object type (this can be
artobjects, makers, packages, or all)

*/

public class Search {
    public static void main(String[] args) {
        try {
            ReqLib reqLib = new ReqLib();

            String endpoint = reqLib.configs.search;
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("q", "blue");
            params.put("type", "artobjects");

            String req = reqLib.makeRequest(endpoint, params);
            System.out.println(req);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}