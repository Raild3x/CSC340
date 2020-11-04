
package astroapi;

public class AstroTestClass {
    
    public static void main(String [] args){
        System.out.println(AstroApi.getBodyInfo("sun", "isplanet"));
        System.out.println(AstroApi.getBodyInfo("moon","isPLanet"));
        System.out.println(AstroApi.getBodyInfo("venus", "isPLAnet"));
        System.out.println(AstroApi.getBodyInfo("mercury", "isPlanet"));
        System.out.println(AstroApi.getBodyInfo("earth", "isPlanet"));
        System.out.println(AstroApi.getBodyInfo("neptune", "isPlanet"));
        System.out.println(AstroApi.getBodyInfo("mars", "isPlanet"));
        System.out.println(AstroApi.getBodyInfo("saturn", "isPlanet"));
        System.out.println(AstroApi.getBodyInfo("uranus", "isPlanet"));
        
        System.out.println(AstroApi.getBodyInfo("sun", "semimajoraxis"));
        System.out.println(AstroApi.getBodyInfo("moon","SEMImajoraxis"));
        System.out.println(AstroApi.getBodyInfo("venus", "semiMAJORaxis"));
        System.out.println(AstroApi.getBodyInfo("mercury", "semimajorAXIS"));
        System.out.println(AstroApi.getBodyInfo("earth", "seMImajorAXis"));
        System.out.println(AstroApi.getBodyInfo("neptune", "semiMAjorAXis"));
        System.out.println(AstroApi.getBodyInfo("mars", "semimajORaxis"));
        System.out.println(AstroApi.getBodyInfo("saturn", "semimajorAXis"));
        System.out.println(AstroApi.getBodyInfo("uranus", "semimajorAXis"));
        
        System.out.println(AstroApi.getBodyInfo("sun", "moOns"));
        System.out.println(AstroApi.getBodyInfo("moon","MooNS"));
        System.out.println(AstroApi.getBodyInfo("neptune", "moons"));
        System.out.println(AstroApi.getBodyInfo("earth", "MOONS"));
        System.out.println(AstroApi.getBodyInfo("venus", "mOoNs"));
        System.out.println(AstroApi.getBodyInfo("mercury", "moonS"));
        System.out.println(AstroApi.getBodyInfo("mars", "mooNS"));
        System.out.println(AstroApi.getBodyInfo("saturn", "moONs"));
        System.out.println(AstroApi.getBodyInfo("uranus", "mOONs"));
        
        System.out.println(AstroApi.getBodyInfo("sun", "mass"));
        System.out.println(AstroApi.getBodyInfo("moon","Mass"));
        System.out.println(AstroApi.getBodyInfo("neptune", "MAss"));
        System.out.println(AstroApi.getBodyInfo("earth", "MASs"));
        System.out.println(AstroApi.getBodyInfo("venus", "MASS"));
        System.out.println(AstroApi.getBodyInfo("mercury", "mASS"));
        System.out.println(AstroApi.getBodyInfo("mars", "maSS"));
        System.out.println(AstroApi.getBodyInfo("saturn", "masS"));
        System.out.println(AstroApi.getBodyInfo("uranus", "mass"));
        
        System.out.println(AstroApi.getBodyInfo("Earth", "moons"));
        System.out.println(AstroApi.getBodyInfo("earth","Mons"));
        System.out.println(AstroApi.getBodyInfo("earth", "vol"));
        System.out.println(AstroApi.getBodyInfo("earth", "volume"));
        System.out.println(AstroApi.getBodyInfo("earth", "sideralRotation"));
        System.out.println(AstroApi.getBodyInfo("earth", "sideralRot"));
        System.out.println(AstroApi.getBodyInfo("earth", "aroundPlanet"));
        System.out.println(AstroApi.getBodyInfo("earth", "planets its around"));
        System.out.println(AstroApi.getBodyInfo("earth", "axialtillt"));
        
    }
}
