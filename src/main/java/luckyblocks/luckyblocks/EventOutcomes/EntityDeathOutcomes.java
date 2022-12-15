package luckyblocks.luckyblocks.EventOutcomes;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntityDeathOutcomes {


    //use default no argument constructor

    /**
     * Determines if a good, bad, or neutral outcome will happen
     * @param entityKiller
     */
    public void outcomeDeterminer(Player entityKiller, boolean isChicken){

        //Shouldn't cause a problem but be on the lookout for a typeCast exception
        int chance = (int) Math.round(Math.random()*20);

        // one fourth chance of something bad and one 20th chance of something good happening
        if (chance < 5){
            //bad outcome
            badOutcome(entityKiller);
        } else if (chance == 10){
            //good outcome
            goodOutcome(entityKiller, isChicken);
        }

    }

    /**
     * Causes a good outcome to occur
     * @param entityKiller
     */
    public void goodOutcome(Player entityKiller, boolean isChicken){

        if (isChicken){
            //grant op item
        }

        //This will provide good items

    }

    //TODO: create three meme items that aren't chicken related and one meme item that is chicken related





    /**
     * Causes a bad outcome to occur
     * @param entityKiller
     */

    public void badOutcome(Player entityKiller){




        //Explode randomly
        //get teleported substantially

    }


    /**
     * Spawns a wither
     * @param entityKiller
     */
    public void spawnWither(Player entityKiller){
        World world = entityKiller.getWorld();

        Location spawnLocation = entityKiller.getLocation();
        spawnLocation = spawnLocation.add(Math.random()*10, Math.random()*10, Math.random()*10);

        world.spawnEntity(spawnLocation, EntityType.WITHER);
    }


    /**
     * Spawns a ghast
     * @param player
     */
    public void spawnGhast(Player player){

        World world = player.getWorld();
        Location spawnLocation = player.getLocation();
        spawnLocation = spawnLocation.add(Math.random()*10, Math.random()*10, Math.random()*10);

        world.spawnEntity(spawnLocation, EntityType.GHAST);
    }

    /**
     * Spawns a ravager
     * @param player
     */
    public void spawnRavager(Player player){

        World world = player.getWorld();
        Location spawnLocation = player.getLocation();
        spawnLocation = spawnLocation.add(Math.random()*10, Math.random()*10, Math.random()*4);

        world.spawnEntity(spawnLocation, EntityType.RAVAGER);
    }


    /**
     * Spawns Between 1 and 5 piglin, 0 and 2 skeletons, and 0-1 creepers.
     * @param player
     */
    public void spawnGoonSquad(Player player){

        World world = player.getWorld();
        Location spawnLocation = player.getLocation();

        int numPiglin = (int) Math.round(Math.random()*5);
        int numSkeletons = (int) Math.round(Math.random()*2);
        int numCreeper = (int) Math.round(Math.random()*1);

        //Spawn the piglins
        while (numPiglin > 0){
            world.spawnEntity(spawnLocation.add(Math.random()*5, Math.random()*5, 0), EntityType.PIGLIN);
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
    public void tntRain(Player player){
        Location spawnLocation = player.getLocation();
        World world = player.getWorld();

        int numTNT = (int) Math.round(Math.random()*20) + 10;

        while (numTNT > 0){

            spawnLocation = player.getLocation();
            world.spawnEntity(spawnLocation.add(Math.random()*5, Math.random()*5, Math.random()*5+10), EntityType.PRIMED_TNT);

            numTNT--;

        }

    }


    /**
     * Creates an anvil rain that follows the player around.
     * @param player
     */
    public void anvilRain(Player player){
        Location spawnLocation = player.getLocation();
        World world = player.getWorld();

        int numAnvils = (int) Math.round(Math.random()*150) + 50;

        while (numAnvils > 0){

            spawnLocation = player.getLocation();
            world.spawnFallingBlock(spawnLocation.add(Math.random()*10, Math.random()*10, Math.random()*30+20), Material.ANVIL.createBlockData());

            numAnvils--;

        }

    }

    /**
     * creates a small explosion centered at the offending player.
     * @param player
     */
    public void randomSmallExplosion(Player player){
        Location spawnLocation = player.getLocation();
        World world = player.getWorld();

        world.createExplosion(spawnLocation, 5);

    }


    /**
     * creates, well... a BDE [Big Daddy Explosion]
     * Note that this should be used exceedingly sparingly because it's super busted and unfair.
     * @param player
     */
    public void bigDaddyExplosion(Player player){
        Location spawnLocation = player.getLocation();
        World world = player.getWorld();

        world.createExplosion(spawnLocation, 80);
    }

    /**
     * Teleports the player a random number of blocks.
     * @param player
     */
    public void telePortPlayerRandomly(Player player){
        Location playerLocation = player.getLocation();

        playerLocation.add(Math.random()*10,Math.random()*10,Math.random()*5);

        player.teleport(playerLocation);
    }


}
