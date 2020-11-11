/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.MouseInputController;
import Controllers.GuiController;
import Controllers.Signal;
import Interfaces.InputInterface;
import Services.PlanetService;
import Services.RenderService;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan
 */
public class MouseView implements InputInterface {

    public static void init() {
        Canvas screen = GuiController.getInstance().getCanvas();
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
