/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Interfaces.InputView;
import Models.InputModel;
import Services.PlanetService;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan
 */
public abstract class InputController {
    protected static final InputModel model = InputModel.getInstance();
    
    public InputController(){}
   
    
    //=================================== GETTERS ===================================//
    public double getX() {
        return this.model.getX();
    }
    
    public double getY() {
        return this.model.getY();
    }
    
    //=================================== SETTERS ===================================//
    public void setX(double _x) {
        this.model.setX(_x);
    }
    
    public void setY(double _y) {
        this.model.setY(_y);
    }
    
    public void setXY(double _x, double _y) {
        this.setX(_x);
        this.setY(_y);
    }
}
