package controllers;

import services.PlanetService;
import javafx.scene.input.MouseEvent;

public class MouseInputController extends InputController {

    private static MouseInputController instance;

    private MouseInputController() {
        super();
    }

    public static MouseInputController getInstance() {
        if (instance == null) {
            instance = new MouseInputController();
        }
        return instance;
    }

    public void mouseMoved(MouseEvent e) {
        setXY(e.getX(), e.getY());
    }

    public void mouseDragged(MouseEvent e) {
        setXY(e.getX(), e.getY());
        model.drag();
    }

    public void mouseClicked(MouseEvent e) {
        //setXY(e.getX(), e.getY());
        PlanetService.focusNearestPlanet();
    }

    public void mousePressed(MouseEvent e) {
        setXY(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        setXY(e.getX(), e.getY());
    }
}
