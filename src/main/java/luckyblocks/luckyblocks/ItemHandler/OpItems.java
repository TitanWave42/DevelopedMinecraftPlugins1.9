package luckyblocks.luckyblocks.ItemHandler;

import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class OpItems {

    public static ItemStack kFCluck;

    public static ItemStack swordOfSlaying;

    public static ItemStack boingoStick;

    public static ItemStack goatedBreastPlate;

    public static ItemStack gingerSnap;

    public static ItemStack doorOfDeath;


    public static void init(){

        boingoStick = createBoingoStick();
        goatedBreastPlate = createGoatedBreastPlate();
        kFCluck = createKFCluck();
        swordOfSlaying = createSwordOfSlaying();
        gingerSnap = createGingerSnap();
        doorOfDeath = createDoorOfDeath();

    }

    /**
     * create KFCluck item.
     */
    private static ItemStack createKFCluck(){
        ItemStack item = new ItemStack(Material.COOKED_CHICKEN);
        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10000);
        item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10000);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("KFCluckOff");
        List<String> lore = new ArrayList<>();
        lore.add("Don't Clucking Mess with Me");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }


    /**
     * create swordOfSlaying item.
     */
    private static ItemStack createSwordOfSlaying(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);


        item.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 10);
        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        item.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 10);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Sword Of Swording");
        List<String> lore = new ArrayList<>();
        lore.add("Stabby Sabby");
        meta.setLore(lore);

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;

    }

    /**
     * Create goatedBreastPlate item.
     */
    private static ItemStack createGoatedBreastPlate(){
        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);

        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 10);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
        item.addUnsafeEnchantment(Enchantment.WATER_WORKER, 10);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        item.addUnsafeEnchantment(Enchantment.THORNS, 10);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Anime Breast Plate");
        List<String> lore = new ArrayList<>();
        lore.add("At least an H cup");
        meta.setLore(lore);


        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }


    /**
     * creates gingerSnap item.
     */
    private static ItemStack createGingerSnap(){
        ItemStack item = new ItemStack(Material.COOKIE, 1);
        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 100);
        item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("GingerSnap of Rending and Ruin");
        List<String> lore = new ArrayList<>();
        lore.add("And with this cookie I ");
        lore.add("shall Snap thy presence from mine.");
        lore.add("With it I shall rend your armour");
        lore.add("topple your cities, and bring ruin upon you.");
        lore.add("With this cookie I shall bring you low.");
        lore.add("For the wages of sin is death,");
        lore.add("but the free gift of the GingerSnap is");
        lore.add("eternal life in Christ Jesus our Lord.");
        meta.setLore(lore);


        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);
        return item;

    }


    /**
     * Create boingoStick item.
     */
    private static ItemStack createBoingoStick(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 100);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Bye Bye Stick");
        List<String> lore = new ArrayList<>();
        lore.add("Tap to make problem disappear.");
        meta.setLore(lore);


        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;

    }

    /**
     * creates the door of death.
     */

    private static ItemStack createDoorOfDeath(){
        ItemStack item = new ItemStack(Material.OAK_DOOR, 1);

        item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);


        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Doory the Door");
        List<String> lore = new ArrayList<>();
        lore.add("It's aDOORable.");
        meta.setLore(lore);


        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;

    }

    //Don't need these for a static class
//
//    //Setters:
//
//    /**
//     * sets the kfCluck item
//     * @param item
//     */
//    public void setkFCluck(ItemStack item){
//        this.kFCluck = item;
//    }
//
//    /**
//     * sets the swordOfSlaying item
//     * @param item
//     */
//    public void setSwordOfSlaying(ItemStack item){
//        this.swordOfSlaying = item;
//    }
//
//    /**
//     * sets the boingoStick item
//     * @param item
//     */
//    public void setBoingoStick(ItemStack item){
//        this.boingoStick = item;
//    }
//
//    /**
//     * sets the goatedBreastPlate item
//     * @param item
//     */
//    public void setGoatedBreastPlate(ItemStack item){
//        this.goatedBreastPlate = item;
//    }
//
//    /**
//     * sets the gingerSnap item
//     * @param item
//     */
//    public void setGingerSnap(ItemStack item){
//        this.gingerSnap = item;
//    }
//
//    //Getters
//    public ItemStack getkFCluck(){
//        return this.kFCluck;
//    }
//
//    public ItemStack getSwordOfSlaying(){
//        return this.swordOfSlaying;
//    }
//    public ItemStack getBoingoStick(){
//        return this.boingoStick;
//    }
//    public ItemStack getGoatedBreastPlate(){
//        return this.goatedBreastPlate;
//    }
//    public ItemStack getGingerSnap(){
//        return this.gingerSnap;
//    }
//



}
