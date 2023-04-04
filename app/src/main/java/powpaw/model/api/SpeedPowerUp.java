package powpaw.model.api;

import powpaw.controller.impl.StatsHandler;
import powpaw.model.impl.StatsBuilderImpl;

public class SpeedPowerUp {

    public final Object lock = new Object();
    public void speedUp(){
        synchronized(lock){
            StatsBuilder build = new StatsBuilderImpl();
            double speedN = StatsHandler.getStatsP1().getSpeed()*10;
            build.setSpeed((int)speedN+2);
            StatsHandler.buildStatsP1(build);
            System.out.println(StatsHandler.getStatsP1().getSpeed());
            try{
                lock.wait(4000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            build.setSpeed((int)speedN);
            StatsHandler.buildStatsP1(build);
            System.out.println(StatsHandler.getStatsP1().getSpeed());
        }

    }
}
