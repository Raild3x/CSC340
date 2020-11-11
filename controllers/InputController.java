package controllers;

import interfaces.InputInterface;
import models.InputModel;
import services.PlanetService;
import javafx.scene.input.MouseEvent;

public abstract class InputController {

    protected static final InputModel model = InputModel.getInstance();

    public InputController() {
    }

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
