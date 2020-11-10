/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.PlanetService;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan
 */
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
