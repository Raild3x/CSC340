/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javafx.scene.control.Button;

/**
 *
 * @author Logan
 */
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
