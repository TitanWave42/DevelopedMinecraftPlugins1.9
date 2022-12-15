package luckyblocks.luckyblocks.EventOutcomes;

import org.bukkit.entity.Player;

public class BlockPlaceOutcomes {

    public static void playerReward(Player player){



        double chance = Math.random();

        if (chance < 0.5){

        } else {
            //Gets diamonds
            //gets iron
            //gets gold
            //gets eye of ender
            //gets ender pearl
            //gets food
            //gets blaze powder
            //gets obsidion
        }

    }

    public static void givePlayerMaterial(){
        int itemToSelect = (int) Math.round(Math.random()*8);

        switch (itemToSelect){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
}
