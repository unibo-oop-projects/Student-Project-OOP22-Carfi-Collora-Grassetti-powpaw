package powpaw.model.impl;

import javafx.scene.text.Text;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.DamageMeter;
import powpaw.model.api.Player;

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

    @Override
    public Text toText(Player player) {
        Text damageText = new Text(damage + "%");
        damageText.setStyle("-fx-font: 50 arial;");
        if (player.getNumber() == 1) {
            damageText.setX(ScreenController.SIZE_HD_W / 6);
            damageText.setY(ScreenController.SIZE_HD_H / 6);
        } else {
            damageText.setX(ScreenController.SIZE_HD_W / 1.3);
            damageText.setY(ScreenController.SIZE_HD_H / 6);
        }
        return damageText;
    }
}
