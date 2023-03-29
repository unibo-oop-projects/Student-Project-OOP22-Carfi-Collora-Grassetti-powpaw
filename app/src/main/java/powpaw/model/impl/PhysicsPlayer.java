package powpaw.model.impl;

public class PhysicsPlayer {
    
    private PlayerImpl player;
    private TransitionFactory transition = new TransitionFactory();

    public PhysicsPlayer(PlayerImpl player){
        this.player = player;
    }

   /*  private boolean doJump(){
        if(transition.checkCollisionByPos(player.getPosition())) {
            return true;
        }
        return false;
    } */
}
