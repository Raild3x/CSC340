import javafx.scene.paint.Color;


public class PlanetService{

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