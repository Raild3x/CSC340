
package Controllers;

/**
 *
 * @author szoor
 */
public class KeyboardInputController extends InputController {
     private static KeyboardInputController instance;
    
    private KeyboardInputController() {
        super();
    }
    
    public static KeyboardInputController getInstance() {
        if (instance == null) {
            instance = new KeyboardInputController();
        }
        return instance;
    }
    
    public void keyPressed(){
        
    }
}