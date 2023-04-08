package powpaw.view.impl;

import javafx.scene.text.Text;

public class DamageMeterRender {
    private Text damage;

    public DamageMeterRender(Text p1){
        this.damage = p1;
    }
    public Text getDamage(){
        return this.damage;
    }
}
