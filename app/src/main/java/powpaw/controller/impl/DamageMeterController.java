package powpaw.controller.impl;

import powpaw.controller.api.PlayerController;
import powpaw.view.impl.DamageMeterRender;

/**
 * DamageMeterController that create and set DamageMeterRender
 * 
 * @author Simone Collorà
 */
public class DamageMeterController {
    private DamageMeterRender render;

    public DamageMeterController(PlayerController controller) {
        render = new DamageMeterRender(controller.getPlayers());
    }

    /**
     * Get render
     * @return render
     */
    public DamageMeterRender getRender() {
        return this.render;
    }
}
