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
import Objects.CelestialBody;


public class PlanetService{

    private PlanetService() {
        throw new IllegalStateException("Service class");
    }

    public static void Init(){
        InitPlanets();
    }

    private static void InitPlanets(){
        CelestialBody center = new CelestialBody("Earth", Color.BLUE, 40);
        RenderService.addInstance(center);
        RenderService.addInstance(new CelestialBody("Moon", Color.WHITE, 20, center, 200));
        RenderService.addInstance(new CelestialBody("Moon2", Color.RED, 30, center, 300));
    }
}
