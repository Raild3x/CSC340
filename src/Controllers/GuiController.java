package Controllers;

import Views.GuiView;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import Models.*;
import Services.PlanetService;
import javafx.scene.Node;

/**
 *
 * @author szoor
 */
public class GuiController {

    private final Canvas canvas;
    private final StackPane stackPane;
    
    protected static GuiController instance;

    private GuiController() {
        this.canvas = new Canvas();
        this.stackPane = new StackPane();
    }

    public static GuiController getInstance() {
        if (instance == null)
            instance = new GuiController();
        return instance;
    }
    
    /*
     * Adds a gui object node (Label, Button, etc..) to the stackPane to be displayed.
     * @param _kids Varargs array of Nodes to be added.
    */
    public void addGuiObject(Node ..._kids) {
        for (Node obj : _kids)
            this.stackPane.getChildren().add(obj);
    }
    
    /*
     * Removes a gui object node (Label, Button, etc..) from the stackPane.
     * @param _kids Varargs array of Nodes to be added.
    */
    public void removeGuiObject(Node ..._kids) {
        for (Node obj : _kids)
            this.stackPane.getChildren().remove(obj);
    }


    //=================================== GETTERS ===================================//
    public StackPane getStackPane() {
        return this.stackPane;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }
    
}
