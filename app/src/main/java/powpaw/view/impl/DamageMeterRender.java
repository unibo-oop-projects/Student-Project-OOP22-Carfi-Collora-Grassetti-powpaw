package powpaw.view.impl;

import javafx.scene.text.Text;

public class DamageMeterRender {
    private Text damageP1;
    private Text damageP2;

    public DamageMeterRender(Text p1, Text p2){
        this.damageP1 = p1;
        this.damageP2 = p2;
    }
    public Text getDamageP1(){
        return this.damageP1;
    }
    public Text getDamageP2(){
        return this.damageP2;
    }
}
