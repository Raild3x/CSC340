package Listeners;

import java.util.EventListener;

public interface PostRenderListener extends EventListener {

    void postRender(double dt);
}
