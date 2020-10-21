/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.CelestialBody;
import Services.RenderService;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Logan
 */
public class CelestialBodyController {
    
    private CelestialBody Model;
    
    public CelestialBodyController(CelestialBody Model){
        this.Model = Model;
    }
    
    public void MoveCelestialBody(double dt){
        Model.update(dt);
        //Model.move(angle);
    }
    
    public void RenderCelestialBody(GraphicsContext gc){
        Model.render(gc);
    }
    
    public void BoldOrbit(boolean val){
        Model.boldOrbit = val;
    }
    
    public double GetX(){
        return Model.getX();
    }
    
    public double GetY(){
        return Model.getY();
    }
    
    public String GetName(){
        return Model.name;
    }
    
    public double GetDistToOrbit(double px, double py){
       return Model.getDistToOrbit(px, py);
    }
    
    public double GetDistToPlanet(double px, double py){
        return Model.getDistToPlanet(px, py);
    }
    
    public void ClickedPlanet(){
        BoldOrbit(true);
        System.out.println("Clicked: "+Model.name);
    }
    
    public void RenderView(){
        
    }
}
