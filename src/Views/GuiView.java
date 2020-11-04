
package Views;


import Controllers.CelestialBodyController;
import Controllers.GuiController;
import Services.PlanetService;
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

    protected final GuiController guiController;
    protected static GuiView instance;

    private GuiView() {
        this.guiController = GuiController.getInstance();
        this.init();
    }
    
    public static GuiView getInstance() {
        if (instance == null)
            instance = new GuiView();
        return instance;
    }
    
    public void init() {
        initButtons();
    }

    public void initButtons() {
        // THIS IS JUST AN EXAMPLE OF HOW TO USE BUTTONS, WE WILL NOT ACTUALLY HAVE A PLANET FOCUS
        // The most likely usage of buttons/labels will be in our popup UIs for when we click on celestial bodies or opening the settings menu.
        Button button = new Button("Click To Shift Focus to Earth");
        button.setStyle("-fx-background-color: #aaaaaa");
        button.setTranslateX(-500);
        button.setTranslateY(-300);
        button.setOnAction(e -> {
            button.setText("Shifted Focus");
            //RenderService.setFocus("Earth");
        });

        Label zoomLbl = new Label("Zoom:");
        zoomLbl.setStyle("-fx-background-color: #aaaaaa");
        zoomLbl.setTranslateX(-500);
        zoomLbl.setTranslateY(-400);
        RenderService.PostRenderstep.Connect(dt -> {
            zoomLbl.setText("ZOOM: " + Double.toString(Math.ceil(RenderService.getInstance().getZoom() * 10) / 10));
        });
        
        final Label planetNameLabel = new Label();
        planetNameLabel.setTranslateX(-500);
        planetNameLabel.setTranslateY(-200);
        planetNameLabel.setFont(Font.font(30));
        PlanetService.HoverBegan.Connect(cbc -> {
            
            planetNameLabel.setText(cbc.getName());

            this.guiController.addGuiObject(planetNameLabel);

        });
        PlanetService.HoverEnded.Connect(cbc -> {
            System.out.println("Stopped hovering over: " + cbc.getName());
            this.guiController.removeGuiObject(planetNameLabel);
        });
        
        PlanetService.Selected.Connect(cbc -> {
           System.out.println("Selected "+cbc.getName());
        });
        PlanetService.UnSelected.Connect(cbc -> {
           System.out.println("UnSelected "+cbc.getName());
        });
        

        guiController.addGuiObject(button, zoomLbl);
    }
    
    public void HoverBegan(CelestialBodyController cbc) {
        System.out.println("Began hovering over: " + cbc.getName());
    }
}