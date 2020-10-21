/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Logan
 */
public class GuiService {

    private GuiService() {
        throw new IllegalStateException("Service class");
    }

    public static void Init(){
        InitButtons();
    }

    public static void InitButtons(){
        Button button = new Button("Click To Shift Focus to Earth");
        button.setStyle("-fx-background-color: #aaaaaa");
        button.setTranslateX(-500);
        button.setTranslateY(-300);
        button.setOnAction(e -> {
            button.setText("Shifted Focus");
            RenderService.setFocus(PlanetService.GetPlanet("Earth"));
        });
        
        Label zoomLbl = new Label("Zoom:");
        zoomLbl.setStyle("-fx-background-color: #aaaaaa");
        zoomLbl.setTranslateX(-500);
        zoomLbl.setTranslateY(-400);
        RenderService.PostRenderstep.Connect(dt ->{
            zoomLbl.setText("ZOOM: "+Double.toString(Math.ceil(RenderService.getZoom()*10)/10));
        });

        RenderService.addButton(zoomLbl);
        RenderService.addButton(button);
    }
    
    public static void SetButtonX(Button btn, double x){
        
    }
}
