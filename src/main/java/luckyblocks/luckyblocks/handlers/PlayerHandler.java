package luckyblocks.luckyblocks.handlers;

import luckyblocks.luckyblocks.LuckyBlocks;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class PlayerHandler implements Listener {


    public PlayerHandler(LuckyBlocks plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);

    }




}
