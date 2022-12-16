package luckyblocks.luckyblocks.EventOutcomes;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.potion.PotionEffectType;

public class BlockBreakOutcomes {

    /**
     * Causes the player to receive a negative effect.
     * @param player
     * @param event
     */
    public static void punishPlayer(Player player, BlockBreakEvent event){

        if (Math.random() < 0.5){
            givePlayerBadEffect(player);
        } {
            causeBadWorldEvent(player, event);
        }
    }

    /**
     * Gives the player a bad potion effect.
     * @param player
     */
    private static void givePlayerBadEffect(Player player){
        int effectToSelect = (int) Math.round(Math.random()*8);

        switch (effectToSelect){
            case 0:
                player.addPotionEffect(PotionEffectType.SLOW_DIGGING.createEffect((int) Math.round(Math.random()*200+15), (int) Math.round(Math.random()*5+1)));
                break;
            case 1:
                player.addPotionEffect(PotionEffectType.HUNGER.createEffect((int) Math.round(Math.random()*200+15), (int) Math.round(Math.random()*5+1)));
                break;
            case 2:
                player.addPotionEffect(PotionEffectType.POISON.createEffect((int) Math.round(Math.random()*200+15), (int) Math.round(Math.random()*5+1)));
                break;
            case 3:
                player.addPotionEffect(PotionEffectType.SLOW.createEffect((int) Math.round(Math.random()*200+15), (int) Math.round(Math.random()*5+1)));
                break;
            case 4:
                player.addPotionEffect(PotionEffectType.WEAKNESS.createEffect((int) Math.round(Math.random()*200+15), (int) Math.round(Math.random()*5+1)));
                break;
            case 5:
                player.addPotionEffect(PotionEffectType.BLINDNESS.createEffect((int) Math.round(Math.random()*200+15), (int) Math.round(Math.random()*5+1)));
                break;
            case 6:
                player.addPotionEffect(PotionEffectType.CONFUSION.createEffect((int) Math.round(Math.random()*200+15), (int) Math.round(Math.random()*5+1)));
                break;
            case 7:
                player.addPotionEffect(PotionEffectType.DARKNESS.createEffect((int) Math.round(Math.random()*200+15), (int) Math.round(Math.random()*5+1)));
                break;
            case 8:
                player.addPotionEffect(PotionEffectType.WITHER.createEffect((int) Math.round(Math.random()*200+15), (int) Math.round(Math.random()*5+1)));

        }

    }

    /**
     * Causes a bad world event to happen to the player (spawns in something to negatively impact gameplay)
     * @param player
     * @param event
     */
    private static void causeBadWorldEvent(Player player, BlockBreakEvent event){

        int effectToSelect = (int) Math.round(Math.random()*8);

        switch (effectToSelect){
            case 0:
                generateCobwebCage(player);
                break;
            case 1:
                floodPlayer(player);
                break;
            case 2:
                spawnPieceOfTNTAtBlock(player, event);
                break;
            case 3:
                dumpLavaOnPlayer(player);
                break;
            case 4:
                spawnPillagerAtBlock(player, event);
                break;
            case 5:
                spawnIllusionerAtBlock(player, event);
                break;
            case 6:
                teleportPlayerSlightly(player);
                break;
            case 7:
                spawnMildTNTRain(player);
                break;
            case 8:
                spawnPieceOfTNTAtPlayer(player);
                break;

        }
    }

    //TODO: Figure out why this isn't working as intended.
    /**
     * Generates a cage of cobwebs
     * @param player
     */
    private static void generateCobwebCage(Player player){
        Location location = player.getLocation();

        Location tempLocation = location;


        for (int i = -1; i<2; i++){
            for (int j = 0; j<3; j++){
                for (int k = -1; i<2; i++){

                    tempLocation = tempLocation.add(i,j,k);
                    tempLocation.getBlock().setType(Material.AIR);
                    tempLocation.getBlock().setType(Material.COBWEB);
                    tempLocation = location;

                }
            }
        }


    }

    /**
     * Spawns two water blocks on the player's location.
     * @param player
     */
    private static void floodPlayer(Player player){
        Location location = player.getLocation();

        location.getBlock().setType(Material.WATER);
        location.add(0,1,0).getBlock().setType(Material.WATER);

    }

    /**
     * Spawns a piece of TNT at the block broken by the player.
     * @param player
     * @param event
     */
    private static void spawnPieceOfTNTAtBlock(Player player, BlockBreakEvent event){
        Location blockBreakLocation = event.getBlock().getLocation();
        World world = player.getWorld();

        world.spawnEntity(blockBreakLocation, EntityType.PRIMED_TNT);

    }


    /**
     * Spawns a piece of tnt at the players location.
     * @param player
     */
    private static void spawnPieceOfTNTAtPlayer(Player player){
        Location location = player.getLocation();
        World world = player.getWorld();

        world.spawnEntity(location, EntityType.PRIMED_TNT);

    }

    private static void spawnMildTNTRain(Player player){
        Location spawnLocation = player.getLocation();
        World world = player.getWorld();

        int numTNT = (int) Math.round(Math.random()*10) + 5;

        while (numTNT > 0){

            spawnLocation = player.getLocation();
            world.spawnEntity(spawnLocation.add(Math.random()*3, Math.random()*10+10, Math.random()*3), EntityType.PRIMED_TNT);

            numTNT--;

        }

    }

    /**
     * Spawns lava above the player.
     * @param player
     */
    private static void dumpLavaOnPlayer(Player player){
        Location location = player.getLocation();
        location.add(0,2, 0);
        location.getBlock().setType(Material.LAVA);
    }

    /**
     * Spawns a vindicator (pillager) at the block most recently broken by the player.
     * @param player
     * @param event
     */
    private static void spawnPillagerAtBlock(Player player, BlockBreakEvent event){
        Location blockBreakLocation = event.getBlock().getLocation();
        World world = player.getWorld();

        world.spawnEntity(blockBreakLocation, EntityType.VINDICATOR);

    }

    /**
     * Spawns an illusioner at the block most recently broke by the player.
     * @param player
     * @param event
     */
    private static void spawnIllusionerAtBlock(Player player, BlockBreakEvent event){
        Location blockBreakLocation = event.getBlock().getLocation();
        World world = player.getWorld();

        world.spawnEntity(blockBreakLocation, EntityType.ILLUSIONER);

    }

    /**
     * Teleports the player slightly.
     * @param player
     */
    private static void teleportPlayerSlightly(Player player){
        player.teleport(player.getLocation().add(Math.random()*7, Math.random()*3, Math.random()*7));

    }


}
