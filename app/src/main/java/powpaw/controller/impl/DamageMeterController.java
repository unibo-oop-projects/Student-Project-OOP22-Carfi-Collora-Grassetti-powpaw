package powpaw.controller.impl;

import powpaw.controller.api.PlayerController;
import powpaw.view.impl.DamageMeterRender;

public class DamageMeterController {
    private DamageMeterRender render;

    public DamageMeterController(PlayerController controller) {
        render = new DamageMeterRender(controller.getPlayers());
    }

    public DamageMeterRender getRender() {
        return this.render;
    }
}
