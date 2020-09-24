package AstronomyCalendar;

import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.Geolocation;
import io.ipgeolocation.api.IPGeolocationAPI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

/**
 *
 * @author sytiv
 */
public class LocationApi {

    private static final String LOCATION_API_KEY = "18da31d005e94d3c84fe2cf81d79f114";
    private static final String GEO_URL = "https://api.ipgeolocation.io/ipgeo?apiKey=";
    private static final IPGeolocationAPI api = new IPGeolocationAPI(LOCATION_API_KEY);

    public static void getGeoLocation(String _ipAddress) {

        GeolocationParams geoParams = new GeolocationParams();

        geoParams.setIPAddress(_ipAddress);
        geoParams.setFields("geo,time_zone");

        Geolocation geolocation = api.getGeolocation(geoParams);

        if (geolocation.getStatus() == 200) {
            System.out.println(geolocation.getCountryName());
            System.out.println(geolocation.getTimezone().getCurrentTime());
        } else {
            System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
        }
    }
    
    public static void main(String[] args){
        String urlString = GEO_URL + LOCATION_API_KEY;
        URL url;
        String ipAddress = "";
        String latitude = "";
        String longitude = "";
        JSONObject obj = new JSONObject();
        
        try {
            url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            System.out.println("Response Code: " + status);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            
            System.out.println("Output: " + content.toString());
            obj = new JSONObject(content.toString());
            ipAddress = obj.getString("ip");
            latitude = obj.getString("latitude");
            longitude = obj.getString("longitude");
            
        } catch (Exception ex) {
            Logger.getLogger(LocationApi.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        getGeoLocation(ipAddress);
        System.out.println("latitude is: " + latitude +" & longitude is: " + longitude);
        
    }
}
