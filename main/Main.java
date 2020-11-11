package main;

import services.PlanetService;
import services.RenderService;
import javafx.stage.Stage;
import javafx.application.Application;
import views.MouseView;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage _stage) throws Exception {
        RenderService.getInstance(_stage);
        PlanetService.init();
        MouseView.init();

    }

}
