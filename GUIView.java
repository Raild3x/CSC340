package Views;

import Controllers.SolarSystemController;
import Views.*;
import Main.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import Controllers.*;
import Controllers.SignalController.Connection;

public class GUIView {

    private static Stage stage;

    public GUIView(Stage stage) {
        this.stage = stage;

    }

    public static void init() {

        Button focus = new Button("Click To Shift Focus to Earth");
        focus.setStyle("-fx-background-color: #aaaaaa");
        focus.setMaxWidth(100);
        focus.setPrefWidth(100);
        focus.setMinWidth(100);
        TilePane controls = new TilePane(focus);
        controls.setAlignment(Pos.TOP_LEFT);
        Scene scene = new Scene(controls, 600, 600);
        focus.setOnAction(e -> {
            focus.setText("Shifted Focus");

            try {
                SignalController focusCon = new SignalController();
               
            } catch (Exception ex) {
                Logger.getLogger(GUIView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public static void SetButtonX(Button btn, double x) {

    }
}
