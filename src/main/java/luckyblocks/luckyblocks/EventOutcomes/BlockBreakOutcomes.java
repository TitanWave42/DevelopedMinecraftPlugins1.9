package luckyblocks.luckyblocks.EventOutcomes;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.potion.PotionEffectType;

public class BlockBreakOutcomes {




    public static void punishPlayer(Player player, BlockBreakEvent event){

        if (Math.random() < 0.5){
            givePlayerBadEffect(player);
        } {
            causeBadWorldEvent(player, event);
        }
    }

    private static void givePlayerBadEffect(Player player){
        int effectToSelect = (int) Math.round(Math.random()*8);

        switch (effectToSelect){
            case 0:
                player.addPotionEffect(PotionEffectType.SLOW_DIGGING.createEffect((int) Math.round(Math.random()*60+10), (int) Math.round(Math.random()*20)));
                break;
            case 1:
                player.addPotionEffect(PotionEffectType.HUNGER.createEffect((int) Math.round(Math.random()*60+10), (int) Math.round(Math.random()*20+1)));
                break;
            case 2:
                player.addPotionEffect(PotionEffectType.POISON.createEffect((int) Math.round(Math.random()*60+10), (int) Math.round(Math.random()*20+1)));
                break;
            case 3:
                player.addPotionEffect(PotionEffectType.SLOW.createEffect((int) Math.round(Math.random()*60+10), (int) Math.round(Math.random()*20+1)));
                break;
            case 4:
                player.addPotionEffect(PotionEffectType.WEAKNESS.createEffect((int) Math.round(Math.random()*60+10), (int) Math.round(Math.random()*20+1)));
                break;
            case 5:
                player.addPotionEffect(PotionEffectType.BLINDNESS.createEffect((int) Math.round(Math.random()*60+10), (int) Math.round(Math.random()*20+1)));
                break;
            case 6:
                player.addPotionEffect(PotionEffectType.CONFUSION.createEffect((int) Math.round(Math.random()*60+10), (int) Math.round(Math.random()*20+1)));
                break;
            case 7:
                player.addPotionEffect(PotionEffectType.DARKNESS.createEffect((int) Math.round(Math.random()*60+10), (int) Math.round(Math.random()*20+1)));
                break;
            case 8:
                player.addPotionEffect(PotionEffectType.WITHER.createEffect((int) Math.round(Math.random()*60+10), (int) Math.round(Math.random()*20)));

        }

    }

    private static void causeBadWorldEvent(Player player, BlockBreakEvent event){

        int effectToSelect = (int) Math.round(Math.random()*6);

        switch (effectToSelect){
            case 0:
                generateCobwebCage(player);
                break;
            case 1:
                generateNormalCage(player);
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

        }
    }

    private static void generateCobwebCage(Player player){
        Location location = player.getLocation();
        Location tempLocation = location;

        for (int i = -1; i<2; i++){
            for (int j = 0; j<3; j++){
                for (int k = -1; i<2; i++){

                    tempLocation.add(i,j,k).getBlock().setType(Material.COBWEB);
                    tempLocation = location;
                }
            }
        }

    }

    private static void generateNormalCage(Player player){
        Location location = player.getLocation();
        Location tempLocation = location;


        for (int i = -1; i<2; i++){
            for (int j = 0; j<3; j++){
                for (int k = -1; i<2; i++){

                    //Don't spawn iron bars on the player.
                    if (!((i==0 && j==0 && k==0)|| (i==0 && j==1 && k==0))){
                        tempLocation.add(i,j,k).getBlock().setType(Material.IRON_BARS);
                        tempLocation = location;
                    }
                }
            }
        }

    }

    private static void spawnPieceOfTNTAtBlock(Player player, BlockBreakEvent event){
        Location blockBreakLocation = event.getBlock().getLocation();
        World world = player.getWorld();

        world.spawnEntity(blockBreakLocation, EntityType.PRIMED_TNT);

    }

    private static void dumpLavaOnPlayer(Player player){
        Location location = player.getLocation();
        location.add(0,0, 4);
        location.getBlock().setType(Material.LAVA);
    }

    private static void spawnPillagerAtBlock(Player player, BlockBreakEvent event){
        Location blockBreakLocation = event.getBlock().getLocation();
        World world = player.getWorld();

        world.spawnEntity(blockBreakLocation, EntityType.PILLAGER);

    }

    private static void spawnIllusionerAtBlock(Player player, BlockBreakEvent event){
        Location blockBreakLocation = event.getBlock().getLocation();
        World world = player.getWorld();

        world.spawnEntity(blockBreakLocation, EntityType.ILLUSIONER);

    }

    private static void teleportPlayerSlightly(Player player){
        player.teleport(player.getLocation().add(Math.random()*5, Math.random()*3, Math.random()*3));

    }


}
