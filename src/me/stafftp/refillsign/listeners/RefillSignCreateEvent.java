package me.stafftp.refillsign.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class RefillSignCreateEvent implements Listener {

    @EventHandler
    public void onSignChange(SignChangeEvent e) {

        if (e.getLine(1).equalsIgnoreCase(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Refill") && e.getLine(2).equalsIgnoreCase(ChatColor.DARK_RED + "Inventory")) {
            Player p = e.getPlayer();

            if (!(p.hasPermission("refillsign.create"))) {
                p.sendMessage(ChatColor.RED + "No Permission.");
                e.setCancelled(true);
            }
        }
    }
}
