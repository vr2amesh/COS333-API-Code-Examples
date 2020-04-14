import java.util.HashMap;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.Random;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReqLib {

  public Configs configs;

  public ReqLib() {
    this.configs = new Configs();
  }

  public String getAllUndergrads() 
  throws MalformedURLException, IOException, NoSuchAlgorithmException {
    return makeReq(this.configs.base_url + this.configs.all_undergrads);
  }

  public String getOneUndergrad(String netid) 
  throws MalformedURLException, IOException, NoSuchAlgorithmException {
    return makeReq(this.configs.base_url + this.configs.all_undergrads + "/" + netid);
  }

  private String makeReq(
    String urlString
  ) throws MalformedURLException, IOException, NoSuchAlgorithmException {
    // create the header
    HashMap<String, String> header = genheaders();
    
    // make the request
    URL url = new URL(urlString);
    HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();
    for (HashMap.Entry<String, String> entry : header.entrySet()) {
      httpsCon.setRequestProperty(entry.getKey(), entry.getValue());
    }
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

    } else {
      return "Something went terribly wrong. Check to make sure you inputted a valid netid.";
    }
  }

  private HashMap<String, String> genheaders() throws IOException, NoSuchAlgorithmException {
    HashMap<String, String> header = new HashMap<String, String>();

    // create the date
    String created = this.formatDateAsUTC(new Date());

    // create the nonce
    String base64_set = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/=";
    StringBuilder nonceBuilder = new StringBuilder();
    Random ran = new Random();
    for (int i = 0; i < 32; i++) {
      int index = ran.nextInt(base64_set.length());
      nonceBuilder.append(base64_set.charAt(index));
    }
    byte[] nonce = nonceBuilder.toString().getBytes(StandardCharsets.UTF_8);

    String username = this.configs.username + "+" + this.configs.agent;
    String password = this.configs.key;

    // generate the message digest
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    ByteArrayOutputStream concatenatedInputBuilder = new ByteArrayOutputStream();
    concatenatedInputBuilder.write(nonce);
    concatenatedInputBuilder.write(created.getBytes(StandardCharsets.UTF_8));
    concatenatedInputBuilder.write(password.getBytes(StandardCharsets.UTF_8));
    byte[] concatenatedInput = concatenatedInputBuilder.toByteArray();
    byte[] encodedHash = digest.digest(concatenatedInput);
    byte[] generatedDigest = Base64.getEncoder().encode(encodedHash);

    // create the header
    header.put("Authorization", "WSSE profile=\"UsernameToken\"");
    String headerString = String.format(
      "UsernameToken Username=\"%s\", PasswordDigest=\"%s\", Nonce=\"%s\", Created=\"%s\"", 
      username,
      new String(generatedDigest, StandardCharsets.UTF_8),
      new String(Base64.getEncoder().encode(nonce), StandardCharsets.UTF_8),
      created
    );

    header.put("X-WSSE", headerString);
    return header;
  }

  private String formatDateAsUTC(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    return sdf.format(date);
	}

  public static void main(String[] args) {
    ReqLib reqLib = new ReqLib();
    String resp;
    try {
      resp = reqLib.makeReq(
        reqLib.configs.base_url + 
        reqLib.configs.all_undergrads + 
        "/" + "vramesh"
      );
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    System.out.println(resp);
  }
}
