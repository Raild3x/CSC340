
public class CelestialBody {

    private final String name;
    private final double size;
    private final Color color;
    private final double distance;
    private final CelestialBody orbitingBody;

    public boolean displayOrbit = true;

    public CelestialBody (String name, double size, Color color, CelestialBody orbitingBody, double distance) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.orbitingBody = orbitingBody;
        this.distance = distance;
    }

    public CelestialBody (String name, double size, Color color) {
        this.name = name;
        this.size = size;
        this.color = color;
    }

    public void render(){

    }
}