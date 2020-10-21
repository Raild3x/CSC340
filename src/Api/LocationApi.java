package Api;

import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.Geolocation;
import io.ipgeolocation.api.IPGeolocationAPI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;


public class LocationApi {
    private static final String ASTRONOMY_URL = "https://api.ipgeolocation.io/astronomy?apiKey=";
    private static final String API_KEY = "18da31d005e94d3c84fe2cf81d79f114";
    private static final IPGeolocationAPI API = new IPGeolocationAPI(API_KEY);
    private static final GeolocationParams geoParams = new GeolocationParams();
    private static final Geolocation geolocation = API.getGeolocation(geoParams);
    private static JSONObject OBJ;

    enum locationInfo{
        IP,
        latitude,
        longitude,
        city,
        countryName,
        stateOrProv,
        zipcode,
        timezone
    }
    //takes the strings: sunset,sunrise,solar_noon,day_length,sun_altitude,sun_distance,sun_azimuth..
    //more on the google doc in discord, links section
    public static String getAstroInfo(String _event){
        String url = ASTRONOMY_URL + API_KEY + "&lat=" + geolocation.getLatitude() + "&long=" + geolocation.getLongitude();
        getConnection(url);
        try {
            return OBJ.getString(_event);
        } catch (JSONException ex) {
            Logger.getLogger(LocationApi.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    
    public static String getLocationInfo(locationInfo _placeInfo){
        switch(_placeInfo){
            case IP:
                return geolocation.getIPAddress();
            case latitude:
                return geolocation.getLatitude();
            case longitude:
                return geolocation.getLongitude();
            case countryName:
                return geolocation.getCountryName();
            case stateOrProv:
                return geolocation.getStateProvince();
            case city:
                return geolocation.getCity();
            case zipcode:
                return geolocation.getZipCode();
            case timezone:
                return geolocation.getTimezone().toString();
        }
        return "";
    } 
    
    private static void getConnection(String _urlString) {
        URL url;
        try {
            url = new URL(_urlString);
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

            OBJ = new JSONObject(content.toString());
        } catch (Exception ex) {
            Logger.getLogger(LocationApi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
