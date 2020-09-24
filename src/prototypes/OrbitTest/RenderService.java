
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

public class RenderService {

    // Instance
    private static RenderService Renderer;

    // Settings
    private static final int width = 800;
    private static final int height = 600;
    private static int FPS = 144;

    // Variables
    private boolean initialized = false;
    private static int CurrentPage = 0;
    private ArrayList<CelestialBody> gameObjects = new ArrayList<CelestialBody>();

    private RenderService() {
        // Empty Constructor
    }

    public static RenderService getRenderer() {
        if (Renderer == null){
            Renderer = new RenderService();
        }
        return Renderer;
    }

    public void Init(Stage stage) throws Exception {
        if (initialized)
            throw new Exception("RenderService already initialized");
        initialized = true;

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

    public void addInstance(CelestialBody obj){
        gameObjects.add(obj);
    }
}