package inspace;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 13362
 */
public class InSpace extends Application implements EventHandler<ActionEvent> {

    Stage mainWindow;
    Scene scene1, scene2, scene3, scene4, scene5;

    @Override
    public void start(Stage primaryStage) {
        mainWindow = primaryStage;

        Button btn1 = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();
        Button btn4 = new Button();
        Button btn5 = new Button();

        btn1.setText("Earth");
        btn2.setText("Moon");
        btn3.setText("Solar System");
        btn4.setText("Events");
        btn5.setText("Settings");

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);

        btn1.setOnAction((ActionEvent event) -> {
            if (event.getSource() == btn1) {
                System.out.println("you clicked earth");
            }
        });
        btn2.setOnAction((ActionEvent event) -> {
            if (event.getSource() == btn2) {
                System.out.println("you clicked moon");
            }
        });
        btn3.setOnAction((ActionEvent event) -> {
            if (event.getSource() == btn3) {
                System.out.println("you clicked solar system");
            }
        });
        btn4.setOnAction((ActionEvent event) -> {
            if (event.getSource() == btn4) {
                System.out.println("you clicked events");
            }
        });
        btn5.setOnAction((ActionEvent event) -> {
            if (event.getSource() == btn5) {
                System.out.println("you clicked settings");
            }
        });

        scene1 = new Scene(layout1, 300, 250);

        primaryStage.setTitle("inSpace");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
