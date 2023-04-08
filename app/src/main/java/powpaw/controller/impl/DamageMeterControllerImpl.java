package powpaw.controller.impl;

import javafx.scene.text.Text;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.DamageMeter;
import powpaw.model.api.Player;
import powpaw.model.impl.DamageMeterImpl;
import powpaw.model.impl.PlayerStats;
import powpaw.view.impl.DamageMeterRender;

public class DamageMeterControllerImpl {
    private DamageMeter meter;
    private DamageMeterRender render;

    // public DamageMeterControllerImpl(PlayerController controller) {
    //     meter = new DamageMeterImpl();
    //     Text p1 = meterP1.toText();
    //     Text p2 = meterP2.toText();
    //     p1.setX(ScreenController.SIZE_HD_W / 6);
    //     p1.setY(ScreenController.SIZE_HD_H / 6);
    //     p1.setStyle("-fx-font: 50 arial;");
    //     p2.setX(ScreenController.SIZE_HD_W / 1.3);
    //     p2.setY(ScreenController.SIZE_HD_H / 6);
    //     p2.setStyle("-fx-font: 50 arial;");
    //     render = new DamageMeterRender(p1, p2);
    // }

    // public DamageMeter getMeterP1() {
    //     return this.meterP1;
    // }

    // public DamageMeter getMeterP2() {
    //     return this.meterP2;
    // }

    public DamageMeterRender getRender() {
        return this.render;
    }

    // public void damageUp(PlayerController playerController) {
    //     PlayerStats statsP1 = playerController.getPlayerObservable().getPlayers().get(0).getPlayerStats();
    //     PlayerStats statsP2 = playerController.getPlayerObservable().getPlayers().get(1).getPlayerStats();
    //     for(Player player : playerController.getPlayerObservable().getPlayers()){
    //         if(player.getNumber() == 1){
    //             if (statsP1.getAttack() > statsP2.getDefence()) {
    //                 meterP1.setDamage(baseDamage * (statsP1.getAttack() - statsP2.getDefence()));
    //             } else {
    //                 meterP1.setDamage(baseDamage);
    //             }
    //         }else{
    //             if (statsP2.getAttack() > statsP1.getDefence()) {
    //                 meterP2.setDamage(baseDamage * (statsP2.getAttack() - statsP1.getDefence()));
    //             } else {
    //                 meterP2.setDamage(baseDamage);
    //             }
    //         }
    //     }
    // }

}
