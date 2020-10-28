
package astroapi;

/**
 *
 * @author sytiv
 */
public class AstroTestClass {
    
    public static void main(String [] args){
        System.out.println(AstroApi.getBodyInfo("sun", "isPlanet"));
        System.out.println(AstroApi.getBodyInfo("mooN","isPlanet"));
        System.out.println(AstroApi.getBodyInfo("Venus", "isPlanet"));
        System.out.println(AstroApi.getBodyInfo("mercury", "isPlanet"));
        System.out.println(AstroApi.getBodyInfo("MARS", "isPlanet"));
        System.out.println(AstroApi.getBodyInfo("SaTuRn", "isPlanet"));
        
        System.out.println(AstroApi.getBodyInfo("pluto", "name"));
        System.out.println(AstroApi.getBodyInfo("Jupiter", "name"));
        System.out.println(AstroApi.getBodyInfo("neptune", "name"));
        System.out.println(AstroApi.getBodyInfo("uranus", "name"));
        System.out.println(AstroApi.getBodyInfo("earth", "name"));
        System.out.println(AstroApi.getBodyInfo("Sun", "name"));
        
    }
}
