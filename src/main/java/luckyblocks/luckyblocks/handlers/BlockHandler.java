package luckyblocks.luckyblocks.handlers;

import luckyblocks.luckyblocks.EventOutcomes.BlockBreakOutcomes;
import luckyblocks.luckyblocks.EventOutcomes.BlockPlaceOutcomes;
import luckyblocks.luckyblocks.LuckyBlocks;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;


import java.util.Random;

public class BlockHandler implements Listener {

    /**
     * Constructor for BlockHandler Class
     * @param plugin The plugin that this Handler operates within
     */
    public BlockHandler(LuckyBlocks plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){

        Block block = event.getBlock();

        Player player = event.getPlayer();

        double chanceToPunishPlayer = Math.random()*1000;

        if (chanceToPunishPlayer < 100){
            BlockBreakOutcomes.punishPlayer(player, event);
        }

        player.sendMessage("block break testing");

    }


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){

        double chanceToRewardPlayer = Math.random()*1000;

        if (chanceToRewardPlayer < 100){
            BlockPlaceOutcomes.playerReward(event.getPlayer());
        }

        event.getPlayer().sendMessage("block place testing");


    }





//    /**
//     * Generates a random outcome for a player upon a block place or block break action.
//     */
//    public void generateRandomOutcome(Player player){
//
//        //Generate a pseudorandom number from 1 to 10
//        double randomOutcome = Math.random()*10;
//
//        //Determine outcome based on random number
//        if (6.6 < randomOutcome && randomOutcome < 10.0){
//            //Good outcome
//
//            goodOutcome(player);
//
//        } else if (3.3 < randomOutcome && randomOutcome < 6.6){
//            //bad outcome
//
//            badOutcome(player);
//
//        } else {
//            //neutral outcome
//
//            neutralOutcome(player);
//
//        }
//
//
//    }
//
//
//    public void goodOutcome(Player player){
//        player.sendMessage("good");
//    }
//
//    public void badOutcome(Player player){
//        player.sendMessage("bad");
//    }
//
//    public void neutralOutcome(Player player){
//        player.sendMessage("ugly");
//
//    }





}
