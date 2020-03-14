package me.stafftp.refillsign;

import me.stafftp.refillsign.listeners.RefillSignCreateEvent;
import me.stafftp.refillsign.listeners.RefillSignListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RefillSign extends JavaPlugin {

    public void onEnable(){

        Bukkit.getPluginManager().registerEvents(new RefillSignListener(), this);
        Bukkit.getPluginManager().registerEvents(new RefillSignCreateEvent(), this);


    }
}

