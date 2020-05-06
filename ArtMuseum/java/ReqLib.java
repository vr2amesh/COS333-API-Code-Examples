import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class ReqLib {

    public Configs configs;
    private final String FAILED_REQUEST = "FAILED_REQUEST";

    public ReqLib() {
        this.configs = new Configs();
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

    public String makeRequest(
        String endpoint, HashMap<String, Object> params
    ) throws MalformedURLException, IOException {
        String params_string = createParamString(params);
        URL url = new URL(this.configs.base_url + endpoint + params_string);
        HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();

        int responseCode = httpsCon.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsCon.getInputStream()));
            int inputChar;
			StringBuffer response = new StringBuffer();

			while ((inputChar = in.read()) != -1) {
                response.append((char) inputChar);
            }
			in.close();

			// return result
            return response.toString();
        }
        else {
            return FAILED_REQUEST;
        }
    }
    public static void main(String[] args) {
        
    }
}