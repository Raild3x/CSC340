package Services;

/**
 *
 * @author Logan
 */
import javafx.stage.Stage;
import javafx.application.Application;
import Api.*;
import Views.MouseView;


public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        RenderService.Init(stage);
        GuiService.Init();
        PlanetService.Init();
        //LocationApi.Test();
    }

}