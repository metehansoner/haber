package Utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author durmus metehan
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

public class VerifyRecaptcha {

    public static final String url = "https://www.google.com/recaptcha/api/siteverify";
    public static final String secret = "6LfUOYkUAAAAAIy0fDyfrCABVSrBu60cFr5yhQcm";
    private final static String USER_AGENT = "Google";

    public static boolean verify(String gRecaptchaResponse) throws IOException {
        if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
            return false;
        } else {
                URL obj = new URL(url);
                HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
                // add reuqest header
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", USER_AGENT);
                con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                String postParams = "secret=" + secret + "&response="
                        + gRecaptchaResponse;
                // Send post request
                con.setDoOutput(true);
              
             
               return true;
            }
            
    }
}
