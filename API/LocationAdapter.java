package API;

import org.json.*;
import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.Geolocation;
import io.ipgeolocation.api.IPGeolocationAPI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocationAdapter {

    private static final String ASTRONOMY_URL = "https://api.ipgeolocation.io/astronomy?apiKey=";
    private static final String API_KEY = "18da31d005e94d3c84fe2cf81d79f114";
    private static final IPGeolocationAPI api = new IPGeolocationAPI(API_KEY);
    private static final GeolocationParams geoParams = new GeolocationParams();
    private static final Geolocation geolocation = api.getGeolocation(geoParams);
    private static JSONObject OBJ;

    enum locationInfo {
        IP,
        latitude,
        longitude,
        city,
        countryName,
        stateOrProv,
        zipcode,
        timezone
    }

    public static String getAstroInfo(String _event) {
        String url = ASTRONOMY_URL + API_KEY + "&lat=" + geolocation.getLatitude() + "&long=" + geolocation.getLongitude();
        getConnection(url);
        try {
            return OBJ.getString(_event);
        } catch (JSONException ex) {
            Logger.getLogger(LocationAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public static String getLocationInfo(locationInfo _placeInfo) {
        switch (_placeInfo) {
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
            Logger.getLogger(LocationAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(getAstroInfo("sunrise"));
        System.out.println(getAstroInfo("date"));
        System.out.println(getAstroInfo("moon_parallactic_angle"));
        System.out.println(getLocationInfo(locationInfo.IP));
        System.out.println(getLocationInfo(locationInfo.stateOrProv));
        System.out.println(getLocationInfo(locationInfo.latitude));
        System.out.println(getLocationInfo(locationInfo.longitude));
    }
}
