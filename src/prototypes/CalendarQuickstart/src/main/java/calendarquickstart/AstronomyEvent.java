package calendarquickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

enum eventType {
    Sunrise,
    Sunset,
    SolarNoon,
    Moonrise,
    Moonset;
}

public class AstronomyEvent {

    private static final String ASTRONOMY_URL = "https://api.ipgeolocation.io/astronomy?apiKey=";
    private static final String API_KEY = "18da31d005e94d3c84fe2cf81d79f114";
    private static JSONObject OBJ;

    public static String date() {
        return getAstroInfo("date");
    }

    public static String eventTime(eventType _event) {
        switch (_event) {
            case Sunrise:
                return getAstroInfo("sunrise");
            case Sunset:
                return getAstroInfo("sunset");
            case SolarNoon:
                return getAstroInfo("solar_noon");
            case Moonrise:
                return getAstroInfo("moonrise");
            case Moonset:
                return getAstroInfo("moonset");
        }
        return null;
    }

    public static String getAstroInfo(String _event) {
        String url = ASTRONOMY_URL + API_KEY + "&lat=" + LocationApi.getLocationInfo(locationInfo.latitude) + "&long=" + LocationApi.getLocationInfo(locationInfo.longitude);
        getConnection(url);
        try {
            return OBJ.getString(_event);
        } catch (JSONException ex) {
            Logger.getLogger(LocationApi.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
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

    
    public String toString(eventType _event) {
        switch (_event) {
            case Sunrise:
                return "sunrise";
            case Sunset:
                return "sunset";
            case SolarNoon:
                return "solar_noon";
            case Moonrise:
                return "moonrise";
            case Moonset:
                return "moonset";
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getAstroInfo("sunrise"));
        System.out.println(getAstroInfo("date"));
        System.out.println(getAstroInfo("moon_parallactic_angle"));
    }
}
