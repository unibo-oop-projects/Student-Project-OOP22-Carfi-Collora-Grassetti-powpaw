package powpaw.model.api;

import javafx.scene.text.Text;
import powpaw.model.impl.PlayerStats;

public interface DamageMeter {

    int getDamage();

    void setDamage(PlayerStats stats, PlayerStats statsP2);

    Text toText();

}