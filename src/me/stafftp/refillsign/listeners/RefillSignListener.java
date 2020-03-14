package me.stafftp.refillsign.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class RefillSignListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getClickedBlock().getState() instanceof Sign){
                Sign s = (Sign) e.getClickedBlock().getState();

                if(s.getLine(1).equalsIgnoreCase(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Refill") && s.getLine(2).equalsIgnoreCase(ChatColor.DARK_RED + "Inventory")){

                    if (p.hasPermission("refillsign.use")){
                        Inventory refillSign = Bukkit.createInventory(null, 36, ChatColor.DARK_RED + "Refill Inventory");
                        Potion pot = new Potion(PotionType.INSTANT_HEAL);
                        pot.setSplash(true);
                        pot.setLevel(2);
                        ItemStack heal = pot.toItemStack(1);
                        Potion speed = new Potion(PotionType.SPEED);
                        speed.setLevel(2);
                        ItemStack speeditem = speed.toItemStack(1);
                        ItemStack pork = new ItemStack(Material.GRILLED_PORK, 64);
                        ItemStack pearl = new ItemStack(Material.ENDER_PEARL, 16);
                        ItemStack goldensword = new ItemStack(Material.GOLD_SWORD, 1);


                        for (int i = 0; i < refillSign.getSize(); i++){
                            refillSign.setItem(i,heal);
                        }
                        refillSign.setItem(0, pork);
                        refillSign.setItem(1, pearl);
                        refillSign.setItem(9, goldensword);
                        refillSign.setItem(18, goldensword);
                        refillSign.setItem(27, goldensword);
                        refillSign.setItem(7, speeditem);
                        refillSign.setItem(8, speeditem);
                        refillSign.setItem(16, speeditem);
                        refillSign.setItem(17, speeditem);
                        refillSign.setItem(25, speeditem);
                        refillSign.setItem(26, speeditem);

                        p.openInventory(refillSign);
                    } else {
                        e.setCancelled(true);
                        p.sendMessage(ChatColor.RED + "No Permission.");
                    }
                }
            }
        }
    }
}
