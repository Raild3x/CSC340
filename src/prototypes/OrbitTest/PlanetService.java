import javafx.scene.paint.Color;


public class PlanetService{

    public static void Init(){
        InitPlanets();
    }

    private static void InitPlanets(){
        RenderService renderer = RenderService.getRenderer();
        CelestialBody center = new CelestialBody("Earth", Color.BLUE, 40);
        renderer.addInstance(center);
        renderer.addInstance(new CelestialBody("Moon", Color.WHITE, 20, center, 200));
        renderer.addInstance(new CelestialBody("Moon2", Color.RED, 30, center, 300));
    }
}