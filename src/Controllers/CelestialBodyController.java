/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.CelestialBody;
import Views.CelestialBodyView;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Logan
 */
public class CelestialBodyController {
    
    private CelestialBody Model;
    private CelestialBodyView View;
    
    public CelestialBodyController(CelestialBody Model, CelestialBodyView View){
        this.Model = Model;
        this.View = View;
    }
    
    public void MoveCelestialBody(double dt){
        Model.update(dt);
        //Model.move(angle);
    }
    
    public void RenderCelestialBody(GraphicsContext gc){
        Model.render(gc);
    }
    
    public double GetX(){
        return Model.getX();
    }
    
    public double GetY(){
        return Model.getY();
    }
    
    public void RenderView(){
        
    }
}
