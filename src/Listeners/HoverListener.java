package Listeners;

import Controllers.CelestialBodyController;
import java.util.EventListener;

/**
 *
 * @author Logan
 */
public interface HoverListener extends EventListener {
    public void HoverBegan(CelestialBodyController cbc);
    public void HoverEnded(CelestialBodyController cbc);
}
