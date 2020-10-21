/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Logan
 */
import Services.RenderService;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CelestialBody {

    // Test Vars
    private double angle = 0;
    private double dist = 100;
    private double z = 0;
    
    // Properties
    private final double A, B, C;
    public final String name;
    public final double size;
    public final Color color;
    public final CelestialBody orbitingBody;
    private double x = 0;
    private double y = 0;

    public boolean displayOrbit = true;


    public CelestialBody (String name, Color color, double size, CelestialBody orbitingBody, double A, double B, double C) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.orbitingBody = orbitingBody;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public CelestialBody (String name, Color color, double size) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.orbitingBody = null;
        this.A = 0;
        this.B = 0;
        this.C = 0;
    }
    
    public void move(double angle){
        double zoom = RenderService.getZoom();
        x = zoom * B * Math.sin(angle) + C * zoom;
        y = zoom * A * Math.cos(angle);
        if (orbitingBody != null){
            x -= orbitingBody.getX();
            y -= orbitingBody.getY();
        }
    }

    public void update(double dt){
        angle += 0.001;
        move(angle);
    }
    
    public void render(GraphicsContext gc){
        if (orbitingBody != null){
            if (displayOrbit){
                double zoom = RenderService.getZoom();
                // draw orbit
                gc.setStroke(color);
                double x  = orbitingBody.getX() + C*zoom - (A*zoom);
                double y = orbitingBody.getY() - (B*zoom);
                gc.strokeOval(x, y, A*zoom*2, B*zoom*2);
            }
        }
        
        // draw planet
        gc.setFill(color);
        gc.fillOval(x-size/2,y-size/2,size,size);
    }
    
    public double distToOrbit(double px, double py){
        double zoom = RenderService.getZoom();
        double x  = orbitingBody.getX() + C*zoom;
        double y = orbitingBody.getY();
        double rx = A*zoom;
        double ry = B*zoom;
        
        double d1 = Math.sqrt(Math.pow(px-x, 2) + Math.pow(py-y, 2));
        double angle = Math.atan((py - y) / (px - x));
        double d2 = Math.sqrt(Math.pow(rx,2)*Math.pow(Math.cos(angle),2)+Math.pow(ry,2)*Math.pow(Math.sin(angle),2));
        return Math.abs(d1 - d2);
    }
    
        
    public double getX() { return x; }
    public double getY() { return y; }
    public CelestialBody getOrbitingBody(){ return orbitingBody; }
}
