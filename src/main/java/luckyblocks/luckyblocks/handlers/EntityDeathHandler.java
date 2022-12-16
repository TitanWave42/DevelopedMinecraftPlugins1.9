package luckyblocks.luckyblocks.handlers;

import luckyblocks.luckyblocks.EventOutcomes.EntityDeathOutcomes;
import luckyblocks.luckyblocks.ItemHandler.OpItems;
import luckyblocks.luckyblocks.LuckyBlocks;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityDeathHandler implements Listener {



    public EntityDeathHandler(LuckyBlocks plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void entityDeathEffect(EntityDeathEvent deathEvent){
        LivingEntity entity = deathEvent.getEntity();
        boolean isChickenDeath = false;

        //Have to verify that player isn't null before using it somewhere.
        Player player = entity.getKiller();

        //This has to do it
        player.getInventory().addItem(OpItems.kFCluck);

        //Only do something if the entity was killed by a player
        if (!(player == null)){

            player.getInventory().addItem(OpItems.swordOfSlaying);

            //check if the death was a chicken death.
            if (isChickenDeath(entity)){
                isChickenDeath = true;

                player.sendMessage("Chicken death true");
                player.getInventory().addItem(OpItems.kFCluck);
            }

            player.sendMessage("Chicken death false");

            //Randomly determine if there will be an entity death effect
            int probEntityDeathEffect = (int) Math.round(Math.random()*10);

            if (probEntityDeathEffect < 3){
                EntityDeathOutcomes.outcomeDeterminer(player, isChickenDeath);
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
