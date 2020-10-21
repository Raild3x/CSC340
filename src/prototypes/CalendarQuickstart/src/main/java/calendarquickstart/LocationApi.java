package calendarquickstart;

import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.Geolocation;
import io.ipgeolocation.api.IPGeolocationAPI;
import org.json.JSONObject;

/**
 *
 * @author sytiv
 */
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

public class LocationApi {
    
    private static final String API_KEY = "18da31d005e94d3c84fe2cf81d79f114";
    private static final IPGeolocationAPI API = new IPGeolocationAPI(API_KEY);
    private static final GeolocationParams geoParams = new GeolocationParams();
    private static final Geolocation geolocation = API.getGeolocation(geoParams);
    

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
    
    
    //ex of methods
    public static void main(String [] args){
        
        System.out.println(getLocationInfo(locationInfo.IP));
        System.out.println(getLocationInfo(locationInfo.stateOrProv));
        System.out.println(getLocationInfo(locationInfo.latitude));
        System.out.println(getLocationInfo(locationInfo.longitude));
    }
}
