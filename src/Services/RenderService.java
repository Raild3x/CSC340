/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Logan
 */
import Objects.*;

import java.util.ArrayList;
import javafx.util.Duration;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class RenderService {

    // Instance
    private static Canvas canvas;
    private static Scene scene;
    private static StackPane stackPane;
    private static GraphicsContext gc;

    // Settings
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int FPS = 144;

    // Signals
	public static final Signal<Long> Renderstep = new Signal<>();
	public static final Signal<Long> PostRenderstep = new Signal<>();

    // Variables
    private static boolean initialized = false;
    private static ArrayList<CelestialBody> gameObjects = new ArrayList<>();

    private RenderService() {
        throw new IllegalStateException("Service class");
    }
    
    public static void Init(Stage stage) throws Exception {
        if (initialized)
            throw new Exception("RenderService already initialized");
        initialized = true;
        
        stage.setTitle("Orbit Test");
        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(1000 / FPS), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);

        //begin rendering
        stackPane = new StackPane(canvas);
        scene = new Scene(stackPane);
        stage.setScene(scene);
        stage.show();
        tl.play();
    }

    private static void run(GraphicsContext gc){
        // set background color
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        for (CelestialBody body : gameObjects){
            body.render(gc);
        }
    }

    public static void addInstance(CelestialBody obj){
        gameObjects.add(obj);
    }

    public static void addButton(Button button){
        stackPane.getChildren().add(button);
    }

    // Graphic Utility Methods
    public static void fadeIn(double t){

    }
}
