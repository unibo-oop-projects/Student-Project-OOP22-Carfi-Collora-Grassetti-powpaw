package powpaw.controller.impl;

import powpaw.view.impl.DamageMeterRender;

public class DamageMeterController {
    private DamageMeterRender render;

    public DamageMeterController(PlayerController controller) {
        render = new DamageMeterRender(controller.getPlayerList());
    }

    public DamageMeterRender getRender() {
        return this.render;
    }
}
