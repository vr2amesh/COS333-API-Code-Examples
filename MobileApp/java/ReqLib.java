import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.net.MalformedURLException;

public class ReqLib {

    private Configs configs;

    public ReqLib() {
        this.configs = new Configs();
    }

    private String updateConfigs(
        String endpoint, 
        HashMap<String, Object> params
    ) {
        return "Unauthorized Error";
    }

    private String createParamString(HashMap<String, Object> params) {
        String params_string = "";
        if (params.size() > 0) {
            params_string += "?"; 
            for (HashMap.Entry<String, Object> p : params.entrySet()) {
                params_string += p.getKey() + "=" + p.getValue();
                params_string += "&";
            }
            params_string = params_string.substring(0, params_string.length() - 1);
        }
        return params_string;
    }

    public String getRequest(
        String endpoint, 
        HashMap<String, Object> params
    ) throws MalformedURLException, IOException {
        String params_string = createParamString(params);
        
        URL url = new URL(this.configs.base_url + endpoint + params_string);
        HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();

        String bearerAuth = "Bearer " + this.configs.access_token;
        httpsCon.setRequestProperty("Authorization", bearerAuth);

        int responseCode = httpsCon.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsCon.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// return result
			return response.toString();
        } else if (responseCode == HttpsURLConnection.HTTP_UNAUTHORIZED) {
            String response = updateConfigs(endpoint, params);
            return response;
        } else {
            return "Some Bad Error Occurred";
        }
    }
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        try {
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("fmt", "json");
            String req = reqLib.getRequest("/courses/terms", params);
            System.out.println(req);
        } catch(Exception e) {
            throw new RuntimeException();
        }
    }
}