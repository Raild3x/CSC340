
import java.util.ArrayList;
import java.util.Random;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class RenderService extends Application {

    // Settings
    private static final int width = 800;
    private static final int height = 600;
    private static int FPS = 144;

    // Variables
    private static int CurrentPage = 0;
    private ArrayList<CelestialBody> gameObjects = new ArrayList<CelestialBody>();

    public static void Init(args){
        launch(args);
    }

    @Override
    private void start(Stage stage) throws Exception {
        GuiService.Init(stage);
        
        stage.setTitle("Orbit Test");
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(1000 / FPS), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);

        //begin rendering
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc){
        // set background color
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,width,height);

        for (CelestialBody body : gameObjects){
            body.render(gc);
        }
    }

    public static void addObject(CelestialBody obj){

    }
}