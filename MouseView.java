package Views;

import Controllers.SignalController;
import Models.Planet;
import Models.Render;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class MouseView {

    //need to route this through a controller!!!
    // Events
    public static final SignalController<Double> MouseDragged = new SignalController<>();

    private static MouseView instance;
    private final Canvas screen;
    private double lastX = 0;

    // Properties
    private double x = 0;
    private double y = 0;

    private MouseView() {
        screen = Render.getCanvas();
    }

    public static MouseView GetInstance() {
        if (instance == null) {
            instance = new MouseView();
            instance.Init();
        }
        return instance;
    }

    private void Init() {
        //set response to mouse events
        screen.setOnMouseClicked((MouseEvent event) -> {
            lastX = event.getX();
            Planet.focusNearestPlanet();
        });
        screen.setOnMouseDragged((MouseEvent event) -> {
            x = event.getX();
            y = event.getY();

            MouseDragged.fire((event.getX() - lastX) / 2); // pass delta
            lastX = event.getX();
        });
        screen.setOnMouseReleased((MouseEvent event) -> {
            //System.out.println("mouseReleased: "+event.getX());
        });

        screen.setOnMouseMoved((MouseEvent event) -> {
            x = event.getX();
            y = event.getY();
        });
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
