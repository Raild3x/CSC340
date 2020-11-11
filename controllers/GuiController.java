package controllers;

import views.GuiView;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import javafx.scene.image.Image;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

/**
 *
 * @author szoor
 */
public class GuiController {

    private static final int WIDTH = 1400;
    private static final int HEIGHT = 850;
    private final Canvas canvas;
    private final StackPane stackPane;
    private URL url;
//    private final File file = new File("C:\\Users\\szoor\\OneDrive\\Pictures\\Space-PNG-Picture.png");

    private static GuiView guiView = GuiView.getInstance();
    protected static GuiController instance;

    private GuiController() {
        this.canvas = new Canvas();
        this.stackPane = new StackPane();
        try {
            this.stackPane.getChildren().add(getImageView()); // background layer, I'm doing this here because it needs to be added first, always. otherwise it overlays - Taylor
        } catch (URISyntaxException ex) {
            Logger.getLogger(GuiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //if needing to create a new screen, have capability to create a new instance, then for example change getInstancePrimary() to getInstanceSecondary()

    public static GuiController getInstance() {
        if (instance == null) {
            instance = new GuiController();
        }
        return instance;
    }

    /*
     * Adds a gui object node (Label, Button, etc..) to the stackPane to be displayed.
     * @param _kids Varargs array of Nodes to be added.
     */
    public void addGuiObject(Node... _kids) {
        for (Node obj : _kids) {
            this.stackPane.getChildren().add(obj);
        }
    }

    public void removeGuiObject(Node... _kids) {
        for (Node obj : _kids) {
            this.stackPane.getChildren().remove(obj);
        }
    }

    //=================================== GETTERS ===================================//
//    public URL getURL() {
//        try {
//            url = new URL("http://clipart-library.com/image_gallery2/Space-PNG-Picture.png");
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(GuiController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return url;
//   }
    public StackPane getStackPane() throws URISyntaxException {
        return this.stackPane;
    }

    public Canvas getCanvas() {
        this.canvas.setHeight(HEIGHT);
        this.canvas.setWidth(WIDTH);
        return this.canvas;
    }

    public ImageView getImageView() throws URISyntaxException {
       // Image image = new Image("https://cdn.pixabay.com/photo/2016/01/27/15/25/space-1164579_1280.png");
        Image image = new Image("http://clipart-library.com/images_k/space-png-transparent/space-png-transparent-11.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(HEIGHT);
        imageView.setFitWidth(WIDTH);
//        imageView.setOpacity(0.7);
        return imageView;
    }

}
