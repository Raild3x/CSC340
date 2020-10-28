package Models;

import javafx.scene.paint.Color;
import Models.CelestialBody;
import Controllers.CelestialBodyController;
import Views.MouseView;
import java.util.Hashtable;

public class Planet {

    private static Hashtable<String, CelestialBodyController> CelestialBodyControllers = new Hashtable<String, CelestialBodyController>();

    public Planet() {
        init();
    }

    public static void init() {
        InitPlanets();
        initPlanetEvents();
    }

    private static void InitPlanets() {
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
        Render.setFocus(getPlanet("Sun"));
    }

    private static CelestialBodyController closest;
    private static double dist;

    private static void initPlanetEvents() {
        MouseView mv = MouseView.GetInstance();
        Render.PostRenderstep.connect(dt -> {
            closest = null;
            dist = Integer.MAX_VALUE;

            CelestialBodyControllers.forEach((name, controller) -> {
                if (controller != Render.getFocus()) {
                    controller.BoldOrbit(false);
                }
                double cd = Math.min(controller.GetDistToOrbit(mv.getX() + Render.getOffsetX(), mv.getY() + Render.getOffsetY()),
                        controller.GetDistToPlanet(mv.getX() + Render.getOffsetX(), mv.getY() + Render.getOffsetY()));
                if (cd < dist) {
                    closest = controller;
                    dist = cd;
                }
            });
            if (dist < 15) {
                closest.ClickedPlanet();
            } else {
                closest = null;
            }
        });
    }

    private static void initNewCelestialBody(CelestialBody cb) {
        CelestialBodyController cbc = new CelestialBodyController(cb);
        CelestialBodyControllers.put(cb.name, cbc);
        Render.addInstance(cbc);
    }

    public static void focusNearestPlanet() {
        if (closest == null) {
            return;
        }
        Render.setFocus(closest);
    }

    public static CelestialBodyController getPlanet(String planetName) {
        return CelestialBodyControllers.get(planetName);
    }
}
