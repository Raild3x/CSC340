/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.CelestialBodyController;
import Models.CelestialBody;
import Services.RenderService;

/**
 *
 * @author Logan
 */
public class CelestialBodyView {
    
    public CelestialBodyView(){
        
    }
    
    public void SetupPlanetEvents(CelestialBodyController planet){
        MouseView mv = MouseView.GetInstance();
        
        RenderService.PostRenderstep.Connect(dt ->{
            double x = mv.getX();
            double y = mv.getY();
            
            
        });
    }
}
