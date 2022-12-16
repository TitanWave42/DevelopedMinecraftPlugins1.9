package luckyblocks.luckyblocks.EventOutcomes;

import luckyblocks.luckyblocks.ItemHandler.OpItems;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

//TODO: Add the door item.  It's aDOORable.
public class EntityDeathOutcomes {


    //use default no argument constructor

    /**
     * Determines if a good, bad, or neutral outcome will happen
     * @param entityKiller
     */
    public static void outcomeDeterminer(Player entityKiller, boolean isChicken){

        //Shouldn't cause a problem but be on the lookout for a typeCast exception
        int chance = (int) Math.round(Math.random()*20);

        // one fourth chance of something bad and one 20th chance of something good happening
        if (chance <= 10){
            //bad outcome
            badOutcome(entityKiller, isChicken);
        } else if (chance > 10){
            //good outcome
            goodOutcome(entityKiller, isChicken);
        }

    }

    /**
     * Causes a good outcome to occur
     * @param entityKiller - the player who killed the given entity
     */
    private static void goodOutcome(Player entityKiller, boolean isChicken){

        if (isChicken){
            //grant op item
            entityKiller.getInventory().addItem(OpItems.kFCluck);
        } else {
            int randomItemChance = (int) Math.round(Math.random()*5);

            switch (randomItemChance){
                case 0:
                    entityKiller.getInventory().addItem(OpItems.swordOfSlaying);
                    break;
                case 1:
                    entityKiller.getInventory().addItem(OpItems.gingerSnap);
                    break;
                case 2:
                    entityKiller.getInventory().addItem(OpItems.boingoStick);
                    break;
                case 3:
                    entityKiller.getInventory().addItem(OpItems.goatedBreastPlate);
                    break;
                case 4:
                    entityKiller.getInventory().addItem(OpItems.doorOfDeath);

            }


        }

    }



    /**
     * Causes a bad outcome to occur
     * @param entityKiller - the player who killed the given entity.
     */

    private static void badOutcome(Player entityKiller, boolean isChicken){

        //Chicken revenge logic.  I find it funny that I'm literally writing a war between
        //fowl and human interwoven in the larger speedrunning plugin.  Truly what has my life come to?
        if (isChicken){
            entityKiller.playEffect(EntityEffect.HURT_EXPLOSION);
            entityKiller.sendMessage("FOOD POISONING - courtesy of the Chickens");
            entityKiller.addPotionEffect(PotionEffectType.WEAKNESS.createEffect(200, 3));
            entityKiller.addPotionEffect(PotionEffectType.HUNGER.createEffect(200, 2));
            entityKiller.addPotionEffect(PotionEffectType.POISON.createEffect(200, 1));
        }

        int veryBadOutCome = (int) Math.round(Math.random()*100);

        //Low chance of a truly bad outcome occurring.
        if (veryBadOutCome == 1) {
            spawnWither(entityKiller);
        } else if (veryBadOutCome == 10){
            bigDaddyExplosion(entityKiller);
        } else {

            //Handle normal bad outcomes
            int badOutcome = (int) Math.round(Math.random()*6);

            switch (badOutcome){
                case 0 :
                    spawnGhast(entityKiller);
                    break;
                case 1 :
                    spawnGoonSquad(entityKiller);
                    break;
                case 2:
                    tntRain(entityKiller);
                    break;
                case 3:
                    anvilRain(entityKiller);
                    break;
                case 4:
                    randomSmallExplosion(entityKiller);
                    break;
                case 5:
                    telePortPlayerRandomly(entityKiller);
                    break;
                case 6:
                    spawnRavager(entityKiller);

            }
        }


    }


    /**
     * Spawns a wither
     * @param entityKiller
     */
    private static void spawnWither(Player entityKiller){
        World world = entityKiller.getWorld();

        Location spawnLocation = entityKiller.getLocation();
        spawnLocation = spawnLocation.add(Math.random()*5, Math.random()*5, Math.random()*5);

        world.spawnEntity(spawnLocation, EntityType.WITHER);
    }


    /**
     * Spawns a ghast
     * @param player
     */
    private static void spawnGhast(Player player){

        World world = player.getWorld();
        Location spawnLocation = player.getLocation();
        spawnLocation = spawnLocation.add(Math.random()*5, Math.random()*5, Math.random()*5);

        world.spawnEntity(spawnLocation, EntityType.GHAST);
    }

    /**
     * Spawns a ravager
     * @param player
     */
    private static void spawnRavager(Player player){

        World world = player.getWorld();
        Location spawnLocation = player.getLocation();
        spawnLocation = spawnLocation.add(Math.random()*5, Math.random()*4, Math.random()*5);

        world.spawnEntity(spawnLocation, EntityType.RAVAGER);
    }


    /**
     * Spawns Between 1 and 5 piglin, 0 and 2 skeletons, and 0-1 creepers.
     * @param player
     */
    private static void spawnGoonSquad(Player player){

        World world = player.getWorld();
        Location spawnLocation = player.getLocation();

        int numPiglin = (int) Math.round(Math.random()*5);
        int numSkeletons = (int) Math.round(Math.random()*2);
        int numCreeper = (int) Math.round(Math.random()*1);

        //Spawn the piglins
        while (numPiglin > 0){
            world.spawnEntity(spawnLocation.add(Math.random()*5, Math.random()*6, 5), EntityType.PIGLIN);
            numPiglin--;
        }

        //spawn the skeletons
        while (numSkeletons > 0){
            //TODO solve the problem of skeletons catching fire during the day.
            world.spawnEntity(spawnLocation.add(Math.random()*5, Math.random()*5, 0), EntityType.SKELETON);

            numSkeletons--;
        }

        //spawn the creeper
        while (numCreeper > 0){
            world.spawnEntity(spawnLocation.add(Math.random()*5, Math.random()*5, 0), EntityType.CREEPER);
            numCreeper--;
        }


    }

    /**
     * Creates a lit tnt rain that follows the player around.
     * @param player
     */
    private static void tntRain(Player player){
        Location spawnLocation = player.getLocation();
        World world = player.getWorld();

        int numTNT = (int) Math.round(Math.random()*50) + 30;

        while (numTNT > 0){

            spawnLocation = player.getLocation();
            world.spawnEntity(spawnLocation.add(Math.random()*10, Math.random()*10+20, Math.random()*10), EntityType.PRIMED_TNT);

            numTNT--;

        }

    }


    /**
     * Creates an anvil rain that follows the player around.
     * @param player
     */
    private static void anvilRain(Player player){
        Location spawnLocation = player.getLocation();
        World world = player.getWorld();

        int numAnvils = (int) Math.round(Math.random()*200) + 50;

        while (numAnvils > 0){

            spawnLocation = player.getLocation();
            world.spawnFallingBlock(spawnLocation.add(Math.random()*10, Math.random()*30+40, Math.random()*10),
                    Material.ANVIL.createBlockData());

            numAnvils--;

        }

    }

    /**
     * creates a small explosion centered at the offending player.
     * @param player
     */
    private static void randomSmallExplosion(Player player){
        Location spawnLocation = player.getLocation();
        World world = player.getWorld();

        world.createExplosion(spawnLocation, 3);

    }


    /**
     * creates, well... a BDE [Big Daddy Explosion]
     * Note that this should be used exceedingly sparingly because it's super busted and unfair.
     * @param player
     */
    private static void bigDaddyExplosion(Player player){
        Location spawnLocation = player.getLocation();
        World world = player.getWorld();

        world.createExplosion(spawnLocation, 80);
    }

    /**
     * Teleports the player a random number of blocks.
     * @param player
     */
    private static void telePortPlayerRandomly(Player player){
        Location playerLocation = player.getLocation();

        playerLocation.add(Math.random()*10,Math.random()*5,Math.random()*10);

        player.teleport(playerLocation);
    }


}
