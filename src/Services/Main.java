package Services;

/**
 *
 * @author Logan
 */
import javafx.stage.Stage;
import javafx.application.Application;


public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        RenderService.Init(stage);
        GuiService.Init();
        PlanetService.Init();
    }

}