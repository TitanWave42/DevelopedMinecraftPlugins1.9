package luckyblocks.luckyblocks.handlers;

import luckyblocks.luckyblocks.LuckyBlocks;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathHandler implements Listener {



    public EntityDeathHandler(LuckyBlocks plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void entityDeathEffect(EntityDeathEvent deathEvent){
        LivingEntity entity = deathEvent.getEntity();

        //Have to verify that player isn't null before using it somewhere.
        Player player = entity.getKiller();

        //Only do something if the entity was killed by a player
        if (!(player == null)){

            //check if the death was a chicken death.
            if (isChickenDeath(entity)){

            } else {

            }

        }

    }

    /**
     * Checks if the entity killed was a chicken.
     * @param entity
     * @return
     */
    public boolean isChickenDeath(LivingEntity entity){
        EntityType type = entity.getType();

        //Since enum can prob use == instead of .equals().
        if (type == EntityType.CHICKEN){

            return true;
        }
        return false;
    }


}
