package astroapi;

/**
 *Class is used to force parameters for API to be correct
 */
public enum DataParams {
    ID("id"),
    FRENCHNAME("name"),
    ENGLISHNAME("englishName"),
    ISPLANET("isPlanet"),
    MOONS("moons"),
    ECCENTRICITY("eccentricity"),
    SEMIMAJORAXIS("semimajorAxis"),
    INCLINATION("inclination"),
    MASS("mass"),
    VOL("vol"),
    DENSITY("density"),
    GRAVITY("gravity"),
    EQUARADIUS("equaRadius"),
    SIDERALORBIT("sideralOrbit"),
    SIDERALROTATION("sideralRotation"),
    AROUNDPLANET("aroundPlanet"),
    DISCOVEREDBY("discoveredBy"),
    DISCOVERYDATE("discoveryDate"),
    AXIALTILT("axialTilt");

    String data;

    private DataParams(String _data) {
        this.data = _data;
    }

    public String getData() {
        return data;
    }
}
