package Controllers;

import Views.*;
import Models.*;
import javafx.stage.Stage;

public class SolarSystemController {

    private static Stage stage;

    public SolarSystemController(Stage stage) {
        SolarSystemController.stage = stage;
    }

    public static Render callRender() throws Exception {
        Render render = new Render(stage);
        return render;
    }

    public static void callPlanet() {
        Planet planet = new Planet();
    }

    public static void callCelestialBodyController() {
        //  Celestialbody body = new CelestialBody();

       // CelestialBodyController celeCon = new CelestialBodyController(body);

    }
}
