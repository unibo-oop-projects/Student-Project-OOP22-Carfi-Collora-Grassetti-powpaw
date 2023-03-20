package powpaw.model.impl;

import java.util.concurrent.TimeUnit;

import powpaw.model.api.PowerUp;

public class PowerUpImpl implements PowerUp {

    @Override
    public void attackUp(int attack) {
        try {
            attack += 2;
            TimeUnit.SECONDS.wait(10);
            attack -= 2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void speedUp(int speed) {
        try {
            speed += 2;
            TimeUnit.SECONDS.wait(10);
            speed -= 2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
