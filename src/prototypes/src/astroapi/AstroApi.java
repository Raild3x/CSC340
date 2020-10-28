package astroapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class AstroApi {

    private static final String ASTRONOMY_URL = "https://api.le-systeme-solaire.net/rest/bodies";
    private static JSONObject OBJ;

    
    /*Returns info(_dataWated) of a specific celestial body(_planet). Info on what strings are allowed as _dataWanted
     *here: https://api.le-systeme-solaire.net/en/
     *_body is not case sensitive, _dataWanted is
     */
    public static String getBodyInfo(String _body, String _dataWanted ) {
        String url = ASTRONOMY_URL + "/{" + _body + "}";
        getConnection(url);
        try {
            return OBJ.getString(fixParam(_dataWanted));
        } catch (JSONException ex) {
            Logger.getLogger(AstroApi.class.getName()).log(Level.SEVERE, null, ex);
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
            //System.out.println("Response Code: " + status);   //Used this line to check response code while debugging

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
            Logger.getLogger(AstroApi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Fixes any case sensitive parameters by forcing them to be the correct case
    private static String fixParam(String _param) {
        String toLowerCase = _param.toLowerCase();
        if ("id".equals(toLowerCase) || "name".equals(toLowerCase) || "moons".equals(toLowerCase)
                || "eccentricity".equals(toLowerCase) || "inclination".equals(toLowerCase)
                || "mass".equals(toLowerCase) || "vol".equals(toLowerCase) || "density".equals(toLowerCase)
                || "gravity".equals(toLowerCase)) {
            return toLowerCase;
        } else {
            switch (toLowerCase) {
                case "isplanet":
                    return "isPlanet";
                case "englishname":
                    return "englishName";
                case "semimajorAxis":
                    return "semimajorAxis";
                case "equaradius":
                    return "equaRadius";
                case "sideralorbit":
                    return "sideralOrbit";
                case "sideralrotation":
                    return "sideralRotation";
                case "aroundplanet":
                    return "aroundPlanet";
                case "discoveredby":
                    return "discoveredBy";
                case "discoverydate":
                    return "discoveryDate";
                case "axialtilt":
                    return "axialTilt";
            }
        }
        return "Misspelled or invalid parameter";
    }
}
