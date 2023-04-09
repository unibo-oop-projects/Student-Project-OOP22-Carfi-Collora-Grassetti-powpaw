package powpaw.controller.impl;

import powpaw.controller.api.DamageMeterController;
import powpaw.controller.api.PlayerController;
import powpaw.view.api.DamageMeterRender;
import powpaw.view.impl.DamageMeterRenderImpl;

/**
 * DamageMeterController implementation.
 * 
 * @author Simone Collorà
 */
public class DamageMeterControllerImpl implements DamageMeterController {
    private DamageMeterRender render;

    public DamageMeterControllerImpl(PlayerController controller) {
        render = new DamageMeterRenderImpl(controller.getPlayers());
    }

    @Override
    public DamageMeterRender getRender() {
        return this.render;
    }
}
