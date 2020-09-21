import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CelestialBody {

    private double x = 400;
    private double y = 300;
    private double angle = 0;
    private final String name;
    private final double size;
    private final Color color;
    private final double distance;
    private final CelestialBody orbitingBody;

    public boolean displayOrbit = true;


    public CelestialBody (String name, Color color, double size) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.orbitingBody = null;
        this.distance = 0;
    }

    public CelestialBody (String name, Color color, double size, CelestialBody orbitingBody, double distance) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.orbitingBody = orbitingBody;
        this.distance = distance;
    }

    public void render(GraphicsContext gc){
        if (orbitingBody != null){
             angle += 1 / distance;

             x = orbitingBody.x + distance * Math.cos(angle);
             y = orbitingBody.y + distance * Math.sin(angle);
            if (displayOrbit){
                // draw orbit
                gc.setStroke(Color.WHITE);
                gc.strokeOval(orbitingBody.x - distance, orbitingBody.y - distance, distance*2, distance*2);
            }
        }
        
        // draw planet
        gc.setFill(color);
        gc.fillOval(x-size/2,y-size/2,size,size);
    }
}