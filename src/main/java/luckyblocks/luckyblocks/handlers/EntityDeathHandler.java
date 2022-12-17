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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Score;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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


        //Only do something if the entity was killed by a player
        if (!(player == null)){


            //check if the death was a chicken death.
            if (isChickenDeath(entity)){
                isChickenDeath = true;

                //This is all spagetti code but is here to handle updating scores.
                Score score = PlayerHandler.objective.getScore(player.getName());
                score.setScore(score.getScore()+1);

                int playerScore = score.getScore();

                boolean maxScore = true;

                for (String playerName : PlayerHandler.board.getEntries()){
                    if (PlayerHandler.objective.getScore(playerName).getScore() > playerScore){
                        maxScore = false;
                    }
                }

                //Clears all effects on players on server
                if (maxScore){
                    for (Player online : Bukkit.getOnlinePlayers()){
                        Collection<PotionEffect> effects = new ArrayList<>();
                        effects = online.getActivePotionEffects();

                        for (PotionEffect effect : effects){
                            player.removePotionEffect(effect.getType());
                        }

                    }
                }

                //Effectively Ops the player with the most chicken kills at any given time.
                player.addPotionEffect(PotionEffectType.INCREASE_DAMAGE.createEffect(20*60*1000, 6));
                player.addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE.createEffect(20*60*1000, 3));
                player.addPotionEffect(PotionEffectType.FIRE_RESISTANCE.createEffect(20*60*1000, 6));
                player.addPotionEffect(PotionEffectType.REGENERATION.createEffect(20*60*1000, 2));
                player.addPotionEffect(PotionEffectType.SPEED.createEffect(20*60*1000, 1));
                player.addPotionEffect(PotionEffectType.FAST_DIGGING.createEffect(20*60*1000, 3));





                //player.sendMessage("Chicken death true");
            }

            //player.sendMessage("Chicken death false");

            //Randomly determine if there will be an entity death effect
            int probEntityDeathEffect = (int) Math.round(Math.random()*10);

            if (probEntityDeathEffect < 5){
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
