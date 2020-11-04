package Services;

/**
 *
 * @author Logan
 */
import javafx.stage.Stage;
import javafx.application.Application;
//import Api.*;
import Views.GuiView;
import Views.MouseView;


public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage _stage) throws Exception {
        //Init models and services
        RenderService.getInstance(_stage);
        PlanetService.init();
        
        //Init view events
        MouseView.init();
        GuiView.getInstance();
        
        //LocationApi.Test();
    }

}