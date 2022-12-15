package luckyblocks.luckyblocks.handlers;

import luckyblocks.luckyblocks.LuckyBlocks;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerHandler implements Listener {


    public PlayerHandler(LuckyBlocks plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void sendPlayerMessageUponJoin(PlayerJoinEvent pje){
        Player player = pje.getPlayer();

        String message = "Welcome " + player.getName() + " to the LuckyBlocks speedrun event. " + " As I was creating this plugin my sanity slowly slipped as my" +
                "BloOd BeCaMe R Ed bulL and M_y MInD OnE W   iTH ThE UnIVEsE.";

        player.sendMessage(message);
        message = "Suffice to say this will be difficult for you. The gameplay balance is nonexistent." + " And I who have suffered " +
                "in my labor shall rejoice and exhault in the suffering that you are about to experience.";
        player.sendMessage(message);

        message = "However since I am not without Mercy let me impress upon you one bit of advice to aid you in your Journey.";
        player.sendMessage(message);


        player.sendMessage("KILL THE CHICKENS, KILL THE CHICKENS, KILL THE CHICKENS, KILL THE CHICKENS, KILL THE CHICKENS...");


        player.sendMessage("Good luck >:)");

    }




}
