package Views;

import Controllers.GuiController;
import static Services.PlanetService.HoverBegan;
import static Services.PlanetService.HoverEnded;
import Services.RenderService;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author szoor
 */
public class GuiView {

//    private static StackPane stackPane = new StackPane();
//    private static Canvas canvas = new Canvas();
//
//    private static GuiView instance;
//
//    private GuiView(StackPane stackPane, Canvas canvas) {
//        this.stackPane = stackPane;
//        this.canvas = canvas;
//    }
//
//    public static GuiView getInstance() {
//        if (instance == null) {
//            instance = new GuiView(stackPane, canvas);
//        }
//        return instance;
//    }
    protected static final GuiController guiController = GuiController.getInstance();

    public static void init() {
        initButtons();
    }

    public static void initButtons() {
        // THIS IS JUST AN EXAMPLE OF HOW TO USE BUTTONS, WE WILL NOT ACTUALLY HAVE A PLANET FOCUS
        // The most likely usage of buttons/labels will be in our popup UIs for when we click on celestial bodies or opening the settings menu.
        Button button = new Button("Click To Shift Focus to Earth");
        button.setStyle("-fx-background-color: #aaaaaa");
        button.setTranslateX(-500);
        button.setTranslateY(-300);
        button.setOnAction(e -> {
            button.setText("Shifted Focus");
            RenderService.setFocus("Earth");
        });

        Label zoomLbl = new Label("Zoom:");
        zoomLbl.setStyle("-fx-background-color: #aaaaaa");
        zoomLbl.setTranslateX(-500);
        zoomLbl.setTranslateY(-400);
        RenderService.PostRenderstep.Connect(dt -> {
            zoomLbl.setText("ZOOM: " + Double.toString(Math.ceil(RenderService.getZoom() * 10) / 10));
        });
        final Label planetName = new Label();
        planetName.setTranslateX(-500);
        planetName.setTranslateY(-200);
        planetName.setFont(Font.font(30));
        HoverBegan.Connect(cbc -> {
            System.out.println("Began hovering over: " + cbc.getName());
            planetName.setText(cbc.getName());

            GuiController.getStackPane().getChildren().add(planetName);

        });
        HoverEnded.Connect(cbc -> {
            System.out.println("Stopped hovering over: " + cbc.getName());
            GuiController.getStackPane().getChildren().remove(planetName);
        });

        GuiController.getStackPane().getChildren().addAll(button, zoomLbl);
    }

}
