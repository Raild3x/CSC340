package controllers;

import models.CelestialBody;
import javafx.scene.canvas.GraphicsContext;

public class CelestialBodyController {

    private CelestialBody model;

    public CelestialBodyController(CelestialBody _model) {
        this.model = _model;
    }

    public void moveCelestialBody(double dt) {
        this.model.update(dt);
    }

    public void renderCelestialBody(GraphicsContext gc) {
        this.model.render(gc);
    }

    public void clickPlanet() {
        this.boldOrbit(true);
        System.out.println("Clicked: " + this.getName());
    }

    //=================================== GETTERS ===================================//
    public double getX() {
        return this.model.getX();
    }

    public double getY() {
        return this.model.getY();
    }

    public String getName() {
        return this.model.name;
    }

    public double getDistToOrbit(double px, double py) {
        return this.model.getDistToOrbit(px, py);
    }

    public double getDistToPlanet(double px, double py) {
        return this.model.getDistToPlanet(px, py);
    }

    //=================================== SETTERS ===================================//
    public void boldOrbit(boolean val) {
        this.model.boldOrbit = val;
    }
}
