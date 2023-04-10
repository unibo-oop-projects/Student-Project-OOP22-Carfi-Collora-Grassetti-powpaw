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
public final class DamageMeterControllerImpl implements DamageMeterController {
    private DamageMeterRender render;

    /**
     * DamageMeter costructor.
     * @param controller for every player damage meter.
     */
    public DamageMeterControllerImpl(final PlayerController controller) {
        render = new DamageMeterRenderImpl(controller.getPlayers());
    }

    @Override
    public DamageMeterRender getRender() {
        return this.render;
    }
}
