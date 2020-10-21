/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.Signal;
import Services.RenderService;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan
 */
public class MouseView {
    
    private static MouseView instance;
    private final Canvas screen;
    private double lastX = 0;
    public static final Signal<Double> MouseDragged = new Signal<>();
    
    // Properties
    private double x = 0;
    private double y = 0;
    
    private MouseView(){
        screen = RenderService.getCanvas();
    }
    
    public static MouseView GetInstance(){
        if (instance == null){
            instance = new MouseView();
            instance.Init();
        }
        return instance;
    }
    
    private void Init(){
        //set response to mouse events
        screen.setOnMouseClicked((MouseEvent event) -> {
            //System.out.println("mouseClicked: "+event.getX());
            lastX = event.getX();
        });
        screen.setOnMouseDragged((MouseEvent event) -> {
            //System.out.println("mouseDragging: "+event.getX());
            MouseDragged.Fire((event.getX() - lastX)/2); // pass delta
            lastX = event.getX();
        });
        screen.setOnMouseReleased((MouseEvent event) -> {
            //System.out.println("mouseReleased: "+event.getX());
        });
        
        screen.setOnMouseMoved((MouseEvent event) -> {
            x = event.getX();
            y = event.getY();
        });
    }
    
    public double getX(){ return x; }
    public double getY(){ return y; }
}
