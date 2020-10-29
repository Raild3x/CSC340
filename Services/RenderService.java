package Services;

import Models.*;
import Controllers.CelestialBodyController;
import Controllers.GuiController;
import Models.CelestialBody;
import Controllers.Signal;
import Models.InputModel;
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
import javafx.scene.Node;
import javafx.scene.control.Label;

public class RenderService {

    // Instance
    private static Canvas canvas;
    private static Scene scene;
    private static StackPane stackPane;
    private static GraphicsContext gc;

    // Settings (Finals)
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1000;
    private static final int FPS = 60;
    private static double ZOOM = 12;
    private static final int MAX_ZOOM = 550;
    private static final int MIN_ZOOM = 10;

    // Signals
    public static final Signal<Long> Renderstep = new Signal<>();
    public static final Signal<Long> PostRenderstep = new Signal<>();

    // Variables (Volatile)
    private static double offsetX = 0;
    private static double offsetY = 0;
    private static CelestialBodyController focus;
    private static double goalZOOM = ZOOM;
    private static long lastTick = 0;
    private static boolean initialized = false;
    private static ArrayList<CelestialBodyController> gameObjects = new ArrayList<>();
    protected static final GuiController guiController = GuiController.getInstance();


    /*
    Utilizes a private constructor to emphasize that the class is purely static.
     */
    private RenderService() {
        throw new IllegalStateException("Service class");
    }

    /*
    Initializes the Renderer, sets up the screen and begins the render cycle by calling run every set milliseconds.
    @param _stage The window on which to build the canvas and scene
     */
    public static void init(Stage _stage) throws Exception {
        if (initialized) {
            throw new Exception("RenderService already initialized");
        }
        initialized = true;

        _stage.setTitle("Orbit Test");

        //rerouted the GUI canvas and stackpane to be made in GUIController so I can add buttons to it from GuiView -Taylor
        canvas = GuiController.getCanvas();
        canvas.setHeight(HEIGHT);
        canvas.setWidth(WIDTH);
        gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(1000 / FPS), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);

        stackPane = GuiController.getStackPane();
        stackPane.getChildren().add(canvas);
        scene = new Scene(stackPane);
        _stage.setScene(scene);
        _stage.show();
        lastTick = System.currentTimeMillis();
        //begin rendering
        tl.play();

        // Connect to events
        InputModel.getInstance().InputDragging.Connect(Delta -> {
            goalZOOM += Delta;
            goalZOOM = Math.max(MIN_ZOOM, Math.min(MAX_ZOOM, goalZOOM));
        });
    }

    /*
    Runs every frame and executes planet movement updates and rendering.
    @param _gc GraphicsContext being used to render on.
     */
    private static void run(GraphicsContext _gc) {
        // Do update logic
        ZOOM += (goalZOOM - ZOOM) / 5;
        if (focus != null) {
            offsetX += (focus.getX() - offsetX) / 5;
            offsetY += (focus.getY() - offsetY) / 5;
        }

        // set background color
        _gc.setFill(Color.BLACK);
        _gc.fillRect(0, 0, WIDTH, HEIGHT);

        double dx = getOffsetX();
        double dy = getOffsetY();
        // Update Object Movements
        for (CelestialBodyController body : gameObjects) {
            body.moveCelestialBody(System.currentTimeMillis() - lastTick);
        }
        // Draw Objects
        _gc.translate(-dx, -dy);
        for (CelestialBodyController body : gameObjects) {
            body.renderCelestialBody(_gc);
        }
        _gc.translate(dx, dy);

        PostRenderstep.Fire(System.currentTimeMillis() - lastTick);
        lastTick = System.currentTimeMillis();
    }

    /*
    Adds the Controller of a given CelestialBody to the gameObjects arraylist to be rendered.
    @param _obj The CelestialBodyController that is going to be added.
     */
    public static void addInstance(CelestialBodyController _obj) {
        gameObjects.add(_obj);
    }

    // Graphic Utility Methods
    /*
    --UNDER CONSTRUCTION--
     */
    public static void fadeIn(double t) {

    }

    //=================================== GETTERS ===================================//
    public static CelestialBodyController getFocus() {
        return focus;
    }


    public static double getZoom() {
        return ZOOM;
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

    //=================================== SETTERS ===================================//
    public static void setFocus(CelestialBodyController _focus) {
        focus = _focus;
    }

    public static void setFocus(String _focus) {
        focus = PlanetService.getPlanetController(_focus);
    }
}
