package powpaw.model.impl;

import powpaw.model.api.DamageMeter;

public class DamageMeterImpl implements DamageMeter {
    private int damage;

    public DamageMeterImpl() {
        damage = 0;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void damageUp() {
        damage += 20;
    }

    @Override
    public String toString() {
        return damage + "%";
    }
}
