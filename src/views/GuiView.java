
package views;

import listeners.HoverListener;
import listeners.SelectedListener;
import controllers.CelestialBodyController;
import controllers.GuiController;
import events.HoverEvent;
import events.SelectedEvent;
import services.PlanetService;
import services.RenderService;

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
public class GuiView implements HoverListener, SelectedListener {

    protected static GuiView instance;
    private Label planetNameLabel;
    private Label zoomLabel;

    private GuiView() {
        this.init();
    }
    
    public static GuiView getInstance() {
        if (instance == null)
            instance = new GuiView();
        return instance;
    }
    
    public void init() {
        HoverEvent.addListener(this);
        SelectedEvent.addListener(this);
        initButtons();
    }

    public void initButtons() {
        
        // THIS IS JUST AN EXAMPLE OF HOW TO USE BUTTONS, WE WILL NOT ACTUALLY HAVE A PLANET FOCUS
        // The most likely usage of buttons/labels will be in our popup UIs for when we click on celestial bodies or opening the settings menu.
        /*Button button = new Button("Click To Shift Focus to Earth");
        button.setStyle("-fx-background-color: #aaaaaa");
        button.setTranslateX(-500);
        button.setTranslateY(-300);
        button.setOnAction(e -> {
            button.setText("Shifted Focus");
            //RenderService.setFocus("Earth");
        });*/

        this.zoomLabel = new Label("Zoom:");
        zoomLabel.setStyle("-fx-background-color: #aaaaaa");
        zoomLabel.setTranslateX(-500);
        zoomLabel.setTranslateY(-400);
        RenderService.PostRenderstep.Connect(dt -> {
            zoomLabel.setText("ZOOM: " + Double.toString(Math.ceil(RenderService.getInstance().getZoom() * 10) / 10));
        });
        
        this.planetNameLabel = new Label();
        planetNameLabel.setTranslateX(-500);
        planetNameLabel.setTranslateY(-200);
        planetNameLabel.setFont(Font.font(30));
        
        GuiController.getInstance().addGuiObject(this.zoomLabel);
    }
    
    
    @Override
    public void HoverBegan(CelestialBodyController cbc) {
        System.out.println("Began hovering over: " + cbc.getName());
        this.planetNameLabel.setText(cbc.getName());
        GuiController.getInstance().addGuiObject(this.planetNameLabel);
    }

    @Override
    public void HoverEnded(CelestialBodyController cbc) {
        System.out.println("Stopped hovering over: " + cbc.getName());
        GuiController.getInstance().removeGuiObject(this.planetNameLabel);
    }

    @Override
    public void Selected(CelestialBodyController cbc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UnSelected(CelestialBodyController cbc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}