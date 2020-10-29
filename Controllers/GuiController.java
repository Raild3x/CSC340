package Controllers;

import Views.GuiView;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import Models.*;

/**
 *
 * @author szoor
 */
public class GuiController {

    private static StackPane stackPane = new StackPane();
    private static Canvas canvas = new Canvas();

    protected static GuiController instance;

    public GuiController(StackPane stackPane, Canvas canvas) {
        this.stackPane = stackPane;
        this.canvas = canvas;
    }
    //if needing to create a new screen, have capability to create a new instance, then for example change getInstance() to getInstance1()

    public static GuiController getInstance() {
        if (instance == null) {
            instance = new GuiController(stackPane, canvas);
        }
        return instance;
    }

    public static StackPane getStackPane() {
        return stackPane;
    }

    public static Canvas getCanvas() {
        return canvas;
    }
}
