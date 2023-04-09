package powpaw.model.impl;

import powpaw.model.api.DamageMeter;

/**
 * DamageMeterImpl that implement DamageMeter model.
 * 
 * @author Simone Collorà
 */
public class DamageMeterImpl implements DamageMeter {

    private double damage;

    public DamageMeterImpl() {
        damage = 0;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public void setDamage(double damage) {
        this.damage += damage;
    }

}
