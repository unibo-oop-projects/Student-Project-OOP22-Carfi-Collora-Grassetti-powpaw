package powpaw.Player.model.api;

/**
 * DamageMeter interface.
 * 
 * @author Simone Collorà
 */
public interface DamageMeter {

    /**
     * Return DamageMeter value.
     * 
     * @return DamageMeter value.
     */
    double getDamage();

    /**
     * Increase Damage.
     * 
     * @param damage
     */
    void setDamage(double damage);

}
