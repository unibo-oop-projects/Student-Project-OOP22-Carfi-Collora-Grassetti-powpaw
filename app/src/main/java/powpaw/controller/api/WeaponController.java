package powpaw.controller.api;

import powpaw.model.api.Weapon;
import powpaw.view.impl.WeaponRender;

public interface WeaponController {

    void pickWeapon();

    Weapon getWeapon();

    WeaponRender getRender();

}