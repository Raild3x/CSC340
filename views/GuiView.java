package views;

import controllers.CelestialBodyController;
import controllers.GuiController;
import services.PlanetService;
import services.RenderService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import javafx.scene.text.Font;

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
        if (instance == null) {
            instance = new GuiView();
        }
        return instance;
    }

    public void init() {
        initGui();
    }

//    public void setBackground() {
//        Image spaceImage = this.guiController.getImage();
//        Background space = new Background(new BackgroundImage(spaceImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
//        this.guiController.getStackPane().setBackground(space);
//    }
//moved to GUIController
    public void initGui() {
        final Label appName = new Label("inSpace");
        appName.setStyle("-fx-text-fill : white; -fx-opacity : 0.8;");
        appName.setAlignment(Pos.TOP_CENTER);
        appName.setTranslateY(-395);
        appName.setFont(Font.font(30));
        this.guiController.addGuiObject(appName);

        final Label zoomLbl = new Label();
        zoomLbl.setStyle("-fx-text-fill : white; -fx-opacity : 0.5;");
        zoomLbl.setTranslateX(625);
        zoomLbl.setTranslateY(-400);
        zoomLbl.setFont(Font.font(10));

        RenderService.PostRenderstep.Connect(dt -> {
            zoomLbl.setText("ZOOM: " + Double.toString(Math.ceil(RenderService.getInstance().getZoom() * 10) / 10));
        });
        this.guiController.addGuiObject(zoomLbl);
        final Label planetNameLabel = new Label();
//        planetNameLabel.setTranslateX(-595);
//        planetNameLabel.setTranslateY(-390);
        planetNameLabel.setTranslateX(-400);
        planetNameLabel.setAlignment(Pos.CENTER);
        planetNameLabel.setFont(Font.font(35));
        planetNameLabel.setStyle("-fx-text-fill : white; -fx-opacity : 0.5;");

        PlanetService.HoverBegan.Connect(cbc -> {

            planetNameLabel.setText(cbc.getName());

            this.guiController.addGuiObject(planetNameLabel);

        });
        PlanetService.HoverEnded.Connect(cbc -> {
            System.out.println("Stopped hovering over: " + cbc.getName());
            this.guiController.removeGuiObject(planetNameLabel);
        });

        PlanetService.Selected.Connect(cbc -> {
            System.out.println("Selected " + cbc.getName());
        });
        PlanetService.UnSelected.Connect(cbc -> {
            System.out.println("UnSelected " + cbc.getName());
        });

    }

    public void HoverBegan(CelestialBodyController cbc) {
        System.out.println("Began hovering over: " + cbc.getName());
    }
}
