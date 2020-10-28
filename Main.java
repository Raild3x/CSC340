
package Main;

import javafx.stage.Stage;
import javafx.application.Application;
import API.*;
import Controllers.SolarSystemController;
import Views.MouseView;
import Views.*;


public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        SolarSystemController solarSystem = new SolarSystemController(stage);
        GUIView gui = new GUIView(stage);
      //  Planet.Init();
        //LocationApi.Test();
    }

}