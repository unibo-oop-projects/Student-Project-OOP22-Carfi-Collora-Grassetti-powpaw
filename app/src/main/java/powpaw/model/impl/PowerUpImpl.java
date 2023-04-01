package powpaw.model.impl;


import powpaw.model.api.PowerUp;
import powpaw.model.api.SpeedPowerUp;

public class PowerUpImpl implements PowerUp {

    @Override
    public void attackUp() {
      SpeedPowerUp pow = new SpeedPowerUp();
      new Thread(() ->{pow.speedUp();
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(4000);
                synchronized(pow.lock) {
                    pow.lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void speedUp(int speed) {
        /*try {
            speed += 2;
            TimeUnit.SECONDS.wait(10);
            speed -= 2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
