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

    protected GuiView instance;

    public StackPane getStackPane() {
        return this.instance.getStackPane();
    }

    public Canvas getCanvas() {
        return this.instance.getCanvas();
    }
}
