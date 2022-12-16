package luckyblocks.luckyblocks;

import luckyblocks.luckyblocks.ItemHandler.OpItems;
import luckyblocks.luckyblocks.handlers.BlockHandler;
import luckyblocks.luckyblocks.handlers.EntityDeathHandler;
import luckyblocks.luckyblocks.handlers.PlayerHandler;
import luckyblocks.luckyblocks.util.DelayedTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LuckyBlocks extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getLogger().info("Hello world");

        OpItems.init();

        new PlayerHandler(this);

        new BlockHandler(this);

        new EntityDeathHandler(this);

        new DelayedTask(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getLogger().info("Shutting down");

    }

}



