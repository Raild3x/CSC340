/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Logan
 */
import javafx.scene.paint.Color;
import Models.CelestialBody;
import Controllers.CelestialBodyController;
import Views.CelestialBodyView;
import java.util.Hashtable;


public class PlanetService{

    private static CelestialBodyView view = new CelestialBodyView();
    private static Hashtable<String, CelestialBodyController> CelestialBodyControllers = new Hashtable<String, CelestialBodyController>();
    
    private PlanetService() {
        throw new IllegalStateException("Service class");
    }

    public static void Init(){
        InitPlanets();
    }

    private static void InitPlanets(){
        CelestialBody Sun = new CelestialBody("Sun", Color.YELLOW, 50);
        
        InitNewCelestialBody(new CelestialBody("Mercury", Color.GRAY, 10, Sun, 0.3870, 0.3788, 0.0796));
        InitNewCelestialBody(new CelestialBody("Venus", Color.GREEN, 20, Sun, 0.7219, 0.7219, 0.0049));
        InitNewCelestialBody(new CelestialBody("Earth", Color.BLUE, 25, Sun, 1.0027, 1.0025, 0.0167));
        InitNewCelestialBody(new CelestialBody("Mars", Color.RED, 20, Sun, 1.5241, 1.5173, 0.1424));
        InitNewCelestialBody(new CelestialBody("Jupiter", Color.BEIGE, 50, Sun, 5.2073, 5.2010, 0.2520));
        InitNewCelestialBody(new CelestialBody("Saturn", Color.CHOCOLATE, 40, Sun, 9.5590, 9.5231, 0.5181));
        InitNewCelestialBody(new CelestialBody("Uranus", Color.AQUAMARINE, 30, Sun, 19.1848, 19.1645, 0.9055));
        InitNewCelestialBody(new CelestialBody("Neptune", Color.AQUA, 30, Sun, 30.0806, 30.0788, 0.2687));
        
        InitNewCelestialBody(Sun);
        RenderService.setFocus(GetPlanet("Sun"));
        
    }
    
    private static void InitNewCelestialBody(CelestialBody cb){
        CelestialBodyController cbc = new CelestialBodyController(cb, view);
        CelestialBodyControllers.put(cb.name, cbc);
        RenderService.addInstance(cbc);
    }
    
    public static CelestialBodyController GetPlanet(String planetName){
        return CelestialBodyControllers.get(planetName);
    }
}
