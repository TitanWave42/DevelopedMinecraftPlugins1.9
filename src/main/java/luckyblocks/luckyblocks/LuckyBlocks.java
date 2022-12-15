package luckyblocks.luckyblocks;

import luckyblocks.luckyblocks.handlers.BlockHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LuckyBlocks extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getLogger().info("Hello world");

        new BlockHandler(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getLogger().info("Shutting down");

    }

}



