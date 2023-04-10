package powpaw.Player.controller.impl;

import powpaw.Player.controller.api.DamageMeterController;
import powpaw.Player.controller.api.PlayerController;
import powpaw.Player.view.api.DamageMeterRender;
import powpaw.Player.view.api.DamageMeterRenderImpl;

/**
 * DamageMeterController implementation.
 * 
 * @author Simone Collorà
 */
public final class DamageMeterControllerImpl implements DamageMeterController {
    private final DamageMeterRender render;

    /**
     * DamageMeter costructor.
     * 
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
