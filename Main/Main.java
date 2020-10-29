package Main;

import Services.PlanetService;
import Services.RenderService;
import javafx.stage.Stage;
import javafx.application.Application;
import Api.*;
import Views.GuiView;
import Views.MouseView;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        RenderService.init(stage);
        GuiView.init();
        PlanetService.init();
        MouseView.getInstance();
        //LocationApi.Test();
    }

}
