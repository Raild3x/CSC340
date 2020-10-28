/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astroapi;

/**
 *
 * @author sytiv
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

    DataParams(String _data) {
        this.data = _data;
    }

    public String getData() {
        return data;
    }
}
