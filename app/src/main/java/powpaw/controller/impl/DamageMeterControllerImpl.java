package powpaw.controller.impl;

import javafx.scene.text.Text;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.DamageMeter;
import powpaw.model.impl.DamageMeterImpl;
import powpaw.view.impl.DamageMeterRender;

public class DamageMeterControllerImpl {
    private DamageMeter meterP1;
    private DamageMeter meterP2;
    private DamageMeterRender render;

    public DamageMeterControllerImpl(){
        meterP1 = new DamageMeterImpl();
        meterP2 = new DamageMeterImpl();
        Text p1 = meterP1.toText();
        Text p2 = meterP2.toText();
        p1.setX(ScreenController.SIZE_HD_W/6);
        p1.setY(ScreenController.SIZE_HD_H/6);
        p1.setStyle("-fx-font: 50 arial;");
        p2.setX(ScreenController.SIZE_HD_W/1.3);
        p2.setY(ScreenController.SIZE_HD_H/6);
        p2.setStyle("-fx-font: 50 arial;");
        render = new DamageMeterRender(p1, p2);
    }
    public DamageMeter getMeterP1(){
        return this.meterP1;
    }
    public DamageMeter getMeterP2(){
        return this.meterP2;
    }
    public DamageMeterRender getRender(){
        return this.render;
    }
    public void damageUpP1(){
        meterP1.setDamage(StatsHandler.getStatsP1(),StatsHandler.getStatsP2());
    }
    public void damageUpP2(){
        meterP2.setDamage(StatsHandler.getStatsP2(),StatsHandler.getStatsP1());
    }

}
