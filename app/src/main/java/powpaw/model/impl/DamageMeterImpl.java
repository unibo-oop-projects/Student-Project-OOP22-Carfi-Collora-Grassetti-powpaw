package powpaw.model.impl;

import javafx.scene.text.Text;
import powpaw.model.api.DamageMeter;

public class DamageMeterImpl implements DamageMeter {
    private int damage;
    private final static int baseDamage = 10;

    public DamageMeterImpl() {
        damage = 0;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void setDamage(PlayerStats statsP1, PlayerStats statsP2) {
        if (statsP1.getAttack() > statsP2.getDefence()) {
            this.damage += baseDamage * (statsP1.getAttack() - statsP2.getDefence());
        } else {
            this.damage += baseDamage;
        }
    }

    @Override
    public Text toText() {
        return new Text(damage + "%");
    }
}
