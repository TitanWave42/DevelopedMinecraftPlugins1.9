package luckyblocks.luckyblocks.EventOutcomes;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class BlockPlaceOutcomes {

    /**
     * Gives the player either a material or an effect as a reward
     * @param player
     */
    public static void playerReward(Player player){


        double chance = Math.random();

        if (chance < 0.5){
            givePlayerEffect(player);
        } else {
           givePlayerMaterial(player);
        }

    }


    /**
     * Gives a potion effect or exp to the player.
     * @param player
     */
    private static void givePlayerEffect(Player player){
        int effectToSelect = (int) Math.round(Math.random()*11);

        switch (effectToSelect){
            case 0:
                player.addPotionEffect(PotionEffectType.REGENERATION.createEffect((int) Math.round(Math.random()*520+10), (int) Math.round(Math.random()*20+1)));
                break;
            case 1:
                player.giveExpLevels(5);
                break;
            case 2:
                player.addPotionEffect(PotionEffectType.SPEED.createEffect((int) Math.round(Math.random()*520+10), (int) Math.round(Math.random()*5+1)));
                break;
            case 3:
                player.addPotionEffect(PotionEffectType.JUMP.createEffect((int) Math.round(Math.random()*520+10), (int) Math.round(Math.random()*5+1)));
                break;
            case 4:
                player.addPotionEffect(PotionEffectType.HEALTH_BOOST.createEffect((int) Math.round(Math.random()*520+10), (int) Math.round(Math.random()*5+1)));
                break;
            case 5:
                player.addPotionEffect(PotionEffectType.SATURATION.createEffect((int) Math.round(Math.random()*520+10), (int) Math.round(Math.random()*5+1)));
                break;
            case 6:
                player.addPotionEffect(PotionEffectType.LUCK.createEffect((int) Math.round(Math.random()*520+10), (int) Math.round(Math.random()*5+1)));
                break;
            case 7:
                player.addPotionEffect(PotionEffectType.WATER_BREATHING.createEffect((int) Math.round(Math.random()*520+10), (int) Math.round(Math.random()*5+1)));
                break;
            case 8:
                player.addPotionEffect(PotionEffectType.HEAL.createEffect((int) Math.round(Math.random()*520+10), (int) Math.round(Math.random()*5+1)));
                break;
            case 9:
                player.addPotionEffect(PotionEffectType.FIRE_RESISTANCE.createEffect((int) Math.round(Math.random()*520+10), (int) Math.round(Math.random()*5+1)));
                break;
            case 10:
                player.addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE.createEffect((int) Math.round(Math.random()*520+10), (int) Math.round(Math.random()*5+1)));
                break;
            case 11:
                player.addPotionEffect(PotionEffectType.INCREASE_DAMAGE.createEffect((int) Math.round(Math.random()*520+10), (int) Math.round(Math.random()*5+1)));

        }
    }

    /**
     * Gives a material good to the player.
     * @param player
     */
    private static void givePlayerMaterial(Player player){
        int itemToSelect = (int) Math.round(Math.random()*8);

        switch (itemToSelect){
            case 1:
                player.getInventory().addItem(new ItemStack(Material.DIAMOND, 3));
                break;
            case 2:
                player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 5));
                break;
            case 3:
                player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 3));
                break;
            case 4:
                player.getInventory().addItem(new ItemStack(Material.ENDER_EYE, 1));
                break;
            case 5:
                player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 64));
                break;
            case 6:
                player.getInventory().addItem(new ItemStack(Material.BLAZE_POWDER, 2));
                break;
            case 7:
                player.getInventory().addItem(new ItemStack(Material.OBSIDIAN, 1));
                break;
            case 8:
                player.getInventory().addItem(new ItemStack(Material.EMERALD, 5));

        }
    }
}
