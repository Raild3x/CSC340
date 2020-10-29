package Views;

import Controllers.MouseInputController;
import Controllers.Signal;
import Interfaces.InputInterface;

import javafx.scene.canvas.Canvas;
import Controllers.GuiController;
import javafx.scene.input.MouseEvent;

public class MouseView implements InputInterface {

    private static MouseView instance;
    private final Canvas screen;

    private MouseView() {
        screen = GuiController.getCanvas();
    }

    public static MouseView getInstance() {
        if (instance == null) {
            instance = new MouseView();
            instance.init();
        }
        return instance;
    }

    private void init() {
        MouseInputController mic = MouseInputController.getInstance();
        //set response to mouse events
        screen.setOnMouseClicked((MouseEvent event) -> {
            mic.mouseClicked(event);
        });
        screen.setOnMouseDragged((MouseEvent event) -> {
            mic.mouseDragged(event);
        });
        screen.setOnMousePressed((MouseEvent event) -> {
            mic.mousePressed(event);
        });
        screen.setOnMouseReleased((MouseEvent event) -> {
            mic.mouseReleased(event);
        });
        screen.setOnMouseMoved((MouseEvent event) -> {
            mic.mouseMoved(event);
        });
    }
}
