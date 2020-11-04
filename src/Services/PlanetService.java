package Services;

import Models.*;
import javafx.scene.paint.Color;
import Models.CelestialBody;
import Controllers.CelestialBodyController;
import Models.InputModel;
import Views.MouseView;
import java.util.Hashtable;
import Controllers.Signal;

public class PlanetService {

    // Events
    public static final Signal<CelestialBodyController> HoverBegan = new Signal<>();
    public static final Signal<CelestialBodyController> HoverEnded = new Signal<>();

    // Properties
    private static Hashtable<String, CelestialBodyController> celestialBodyControllers = new Hashtable<String, CelestialBodyController>();
    private static CelestialBodyController closest;
    private static double dist;

    private PlanetService() {
        throw new IllegalStateException("Service class");
    }

    public static void init() {
        initPlanets();
        initPlanetEvents();
    }

    /*
    Manages the creation of all CelestialBody objects
     */
    private static void initPlanets() {
        CelestialBody Sun = new CelestialBody("Sun", Color.YELLOW, 50);

        initNewCelestialBody(new CelestialBody("Mercury", Color.GRAY, 10, Sun, 0.3870, 0.3788, 0.0796));
        initNewCelestialBody(new CelestialBody("Venus", Color.GREEN, 20, Sun, 0.7219, 0.7219, 0.0049));
        initNewCelestialBody(new CelestialBody("Earth", Color.BLUE, 25, Sun, 1.0027, 1.0025, 0.0167));
        initNewCelestialBody(new CelestialBody("Mars", Color.RED, 20, Sun, 1.5241, 1.5173, 0.1424));
        initNewCelestialBody(new CelestialBody("Jupiter", Color.BEIGE, 50, Sun, 5.2073, 5.2010, 0.2520));
        initNewCelestialBody(new CelestialBody("Saturn", Color.CHOCOLATE, 40, Sun, 9.5590, 9.5231, 0.5181));
        initNewCelestialBody(new CelestialBody("Uranus", Color.AQUAMARINE, 30, Sun, 19.1848, 19.1645, 0.9055));
        initNewCelestialBody(new CelestialBody("Neptune", Color.AQUA, 30, Sun, 30.0806, 30.0788, 0.2687));

        initNewCelestialBody(Sun);
        RenderService.setFocus(getPlanetController("Sun"));
    }

    /*
    An organizational method to split up the code. Manages the creation of any events needed to manage the planets.
     */
    private static void initPlanetEvents() {
        InputModel input = InputModel.getInstance();

        // Runs every frame, determines the closest planet/orbit if there is one.
        RenderService.PostRenderstep.Connect(dt -> {
            CelestialBodyController lastClosest = closest;
            closest = null;
            dist = Integer.MAX_VALUE;

            double ix = input.getX();
            double iy = input.getY();
            double ox = RenderService.getOffsetX();
            double oy = RenderService.getOffsetY();

            celestialBodyControllers.forEach((name, controller) -> {
                if (controller != RenderService.getFocus()) {
                    controller.boldOrbit(false);
                }
                double cd = Math.min(controller.getDistToOrbit(ix + ox, iy + oy), controller.getDistToPlanet(ix + ox, iy + oy));
                if (cd < dist) {
                    closest = controller;
                    dist = cd;
                }
            });
            if (dist < 15) {
                if (closest != lastClosest) {
                    if (lastClosest != null) {
                        HoverEnded.Fire(lastClosest);
                    }
                    HoverBegan.Fire(closest);
                }
                closest.boldOrbit(true);
            } else {
                if (lastClosest != null) {
                    HoverEnded.Fire(lastClosest);
                }
                closest = null;
            }
        });
    }

    /*
    Method to simplify creating new celestial bodies and their respective controllers
    @param _cb The CelestialBody object to be used as the base for the controller
     */
    private static void initNewCelestialBody(CelestialBody _cb) {
        CelestialBodyController cbc = new CelestialBodyController(_cb);
        celestialBodyControllers.put(_cb.name, cbc);
        RenderService.addInstance(cbc);
    }

    public static void focusNearestPlanet() {
        if (closest == null) {
            return;
        }
        RenderService.setFocus(closest);
    }

    //=================================== GETTERS ===================================//
    public static CelestialBodyController getPlanetController(String _planetName) {
        return celestialBodyControllers.get(_planetName);
    }
}
