package Controllers;

import Models.*;
import Views.*;
import java.util.HashSet;
import java.util.function.Consumer;

public class SignalController<E> {

    public class Connection {

        public SignalController<E> signal;
        public Consumer<E> func;

        public Connection(SignalController<E> s, Consumer<E> func) {
            this.signal = s;
            this.func = func;
        }

        public void fire() {
            if (this.signal != null) {
                this.signal.connections.remove(this);
                this.signal = null;
                this.func = null;
            }
        }
    }

    public final HashSet<Connection> connections;

    public SignalController() {
        this.connections = new HashSet<>();
    }

    public void fire(E x) {
        this.connections.forEach(c -> {
            c.func.accept(x);
        });
    }

    public void fire() {
        this.connections.forEach(c -> {
            c.func.accept(null);
        });
    }

    public Connection connect(Consumer<E> func) {
        Connection c = new Connection(this, func);
        this.connections.add(c);
        return c;
    }
}

/* EXAMPLES
    // In Keyboard for example
     Signal<int> s = new Signal<>();
     Keyboard.KeyPressed = s;
    //On keyPress
     s.Fire(KeyCode)

    //In some other code
     Connection c = Keyboard.KeyPressed.Connect(KeyCode -> {
        System.out.println("KeyCode: "+KeyCode);
     });
*/
