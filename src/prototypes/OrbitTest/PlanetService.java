public class PlanetService{

    public static void Init(){

    }

    private static void InitPlanets(){
        CelestialBody center = new CelestialBody("Earth", Color.BLUE, 40);
        gameObjects.add(center);
        gameObjects.add(new CelestialBody("Moon", Color.WHITE, 20, center, 200));
        gameObjects.add(new CelestialBody("Moon2", Color.RED, 30, center, 300));
    }
}