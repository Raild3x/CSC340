package Models;

import Controllers.CelestialBodyController;
import Models.CelestialBody;
import Controllers.*;
import Views.MouseView;

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
import javafx.scene.control.Label;

public class Render {

    // Instance
    private static Canvas canvas;
    private static Scene scene;
    private static StackPane stackPane;
    private static GraphicsContext gc;

    // Settings
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1000;
    private static final int FPS = 60;
    private static double ZOOM = 100;
    private static final int MAX_ZOOM = 550;
    private static final int MIN_ZOOM = 10;
    private static double goalZOOM = ZOOM;
    private static double offsetX = 0;
    private static double offsetY = 0;
    private static CelestialBodyController Focus;

    // Signals
    public static final SignalController<Long> Renderstep = new SignalController<>();
    public static final SignalController<Long> PostRenderstep = new SignalController<>();

    // Variables
    private static long lastTick = 0;
    private static boolean initialized = false;
    private static ArrayList<CelestialBodyController> gameObjects = new ArrayList<>();
    private static Stage stage;

    public Render(Stage stage) throws Exception {
        this.stage = stage;
    }

    public static void initRender(Stage stage) throws Exception {
        if (initialized) {
            throw new Exception("RenderService already initialized");
        }
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
        lastTick = System.currentTimeMillis();
        tl.play();

        MouseView.GetInstance().MouseDragged.connect(Delta -> {
            goalZOOM += Delta;
            goalZOOM = Math.max(MIN_ZOOM, Math.min(MAX_ZOOM, goalZOOM));
        });
    }

    private static void run(GraphicsContext gc) {
        // Do update logic
        ZOOM += (goalZOOM - ZOOM) / 5;
        if (Focus != null) {
            offsetX += (Focus.GetX() - offsetX) / 5;
            offsetY += (Focus.GetY() - offsetY) / 5;
        }

        // set background color
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        double dx = getOffsetX();
        double dy = getOffsetY();
        // Update Object Movements
        for (CelestialBodyController body : gameObjects) {
            body.MoveCelestialBody(System.currentTimeMillis() - lastTick);
        }
        // Draw Objects
        gc.translate(-dx, -dy);
        for (CelestialBodyController body : gameObjects) {
            body.RenderCelestialBody(gc);
        }
        gc.translate(dx, dy);

        PostRenderstep.fire(System.currentTimeMillis() - lastTick);
        lastTick = System.currentTimeMillis();
    }

    public static void addInstance(CelestialBodyController obj) {
        gameObjects.add(obj);
    }

    public static void addButton(Button button) {
        stackPane.getChildren().add(button);
    }

    public static void addButton(Label button) {
        stackPane.getChildren().add(button);
    }

    public static void setFocus(CelestialBodyController focus) {
        Focus = focus;
    }

    public static CelestialBodyController getFocus() {
        return Focus;
    }

    public static double getZoom() {
        return ZOOM;
    }

    public static Canvas getCanvas() {
        return canvas;
    }

    public static double getOffsetX() {
        return offsetX - WIDTH / 2;
    }

    public static double getOffsetY() {
        return offsetY - HEIGHT / 2;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }

    // Graphic Utility Methods
    public static void fadeIn(double t) {

    }
}
