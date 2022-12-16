package luckyblocks.luckyblocks.handlers;

import luckyblocks.luckyblocks.LuckyBlocks;
import luckyblocks.luckyblocks.util.DelayedTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.util.HashSet;
import java.util.Set;

public class PlayerHandler implements Listener {


    //I know it's sloppy but I only need one so I'm going to create
    //the scoreboard here instead of in it's own util.  ALso not very safe
    //get off my back, I know.

    public static ScoreboardManager manager = Bukkit.getScoreboardManager();
    public static Scoreboard board = manager.getNewScoreboard();
    public static Objective objective = board.registerNewObjective("chickenKills", Criteria.DUMMY, "Menaces Purged");




    Set<Player> playerSet = new HashSet<>();




    public PlayerHandler(LuckyBlocks plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

    }

    @EventHandler
    public void sendPlayerMessageUponJoin(PlayerJoinEvent pje){
        Player player = pje.getPlayer();

       //Trying to use player names instead of an external player set for convenience.
        if (!(board.getEntries().contains(player.getName()))){
            //playerSet.add(player);
            Team team = board.registerNewTeam(player.getName());
            team.addEntry(player.getName());
            player.setScoreboard(board);
        }


        //Handles greeting the player.
        new DelayedTask(() -> {
            player.sendMessage(ChatColor.GREEN + "Welcome " + player.getName() + ChatColor.GREEN +
                    " to the LuckyBlocks speedrun event. " + ChatColor.GREEN +
                    "As I was creating this plugin my sanity slowly slipped as my " + ChatColor.RED +
                    "BloOd BeCaMe R Ed bulL and M_y MInD OnE W   iTH ThE UnIVEsE.");
        }, 20*5);

        new DelayedTask(() -> {
            player.sendMessage(ChatColor.GREEN + "Suffice to say this will be difficult for you. " + ChatColor.GREEN +
                    "The gameplay balance is nonexistent." + ChatColor.GREEN +
                    " And I who have suffered " + "in my labor shall rejoice and exuberate in the suffering that" +
                    ChatColor.GREEN +
                    " you are about to experience.");
        }, 20*15);

        new DelayedTask(() -> {
            player.sendMessage(ChatColor.GREEN + "However since I am not without " +
                    "Mercy let me impress upon you one bit of" + ChatColor.GREEN +
                    " advice to aid you in your Journey.");
        }, 20*20);


        new DelayedTask(() -> {
            player.sendMessage(ChatColor.RED + "KILL THE CHICKENS, KILL THE CHICKENS, KILL THE CHICKENS, " +
                    "KILL THE CHICKENS, " + ChatColor.RED + "KILL THE CHICKENS...\n" + "KILL THE CHICKENS, " +
                    "KILL THE CHICKENS, KILL THE CHICKENS," + ChatColor.RED + " KILL THE CHICKENS, " + ChatColor.RED +
                    "KILL THE CHICKENS...\n"+"KILL THE CHICKENS, KILL THE CHICKENS, " + ChatColor.RED +
                    "KILL THE CHICKENS," + " KILL THE CHICKENS, " + "KILL THE CHICKENS...");
        }, 20*30);

        new DelayedTask(() -> {
            player.sendMessage(ChatColor.GOLD + "Good luck >:)");
        }, 20*35);




    }




}
