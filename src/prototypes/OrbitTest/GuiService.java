package prototypes.OrbitTest;

import javafx.scene.control.Button;

public class GuiService {

    private GuiService() {
        throw new IllegalStateException("Service class");
    }

    public static void Init(){
        InitButtons();
    }

    public static void InitButtons(){
        Button button = new Button("Click Me!");
        button.setStyle("-fx-background-color: #aa00aa");
        button.setOnAction(e -> button.setText("I've been clicked!"));

        RenderService.addButton(button);
    }
}