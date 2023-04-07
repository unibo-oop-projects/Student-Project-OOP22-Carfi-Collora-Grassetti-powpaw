package powpaw.view.impl;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.text.Text;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;

public class DamageMeterRender {
   private List<Text> damage = new ArrayList<>();

    public DamageMeterRender(List<Player> players) {
        for(int i = 0; i<2; i++){
            damage.add(new Text((int)(players.get(i).getCurrentHealth().getDamage()*10) + "%"));
            damage.get(i).setStyle("-fx-font: 50 arial;");
            damage.get(i).setY(ScreenController.SIZE_HD_H / 6);
        }
        damage.get(0).setX(ScreenController.SIZE_HD_W / 6);
        damage.get(1).setX(ScreenController.SIZE_HD_W / 1.3);
    }

    public List<Text> getDamage() {
        return this.damage;
    }

    public void update(List<Player> players) {
        for(int i = 0; i<2; i++){
            damage.get(i).setText((int)(players.get(i).getCurrentHealth().getDamage()*10) + "%");
        }
    }

}
