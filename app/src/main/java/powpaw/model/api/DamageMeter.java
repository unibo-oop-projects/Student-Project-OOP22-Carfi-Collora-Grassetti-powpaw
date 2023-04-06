package powpaw.model.api;

import javafx.scene.text.Text;

public interface DamageMeter {

    double getDamage();

    void setDamage(double damage);

    Text toText(Player player);

}