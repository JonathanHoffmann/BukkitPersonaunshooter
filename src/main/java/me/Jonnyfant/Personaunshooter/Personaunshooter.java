package me.Jonnyfant.Personaunshooter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Personaunshooter extends JavaPlugin {
    //Config Path
    String pathprioNormal = "Priority: Normal (Recommended)";
    String pathprioHigh = "Priority: High";
    String pathprioHighest = "Priority: Highest";

    @Override
    public void onEnable() {
        loadConfig();
        startAListener();
    }
    public void startAListener()
    {
        if(getConfig().getBoolean(pathprioHighest))
        {
            getServer().getPluginManager().registerEvents(new ArrowListenerHIGHEST(), this);
            Bukkit.broadcastMessage("Personaunshooter is enabled and runs on Highest Priority");
        }
        else
        {
            if(getConfig().getBoolean(pathprioHigh))
            {
                getServer().getPluginManager().registerEvents(new ArrowListenerHIGH(), this);
                Bukkit.broadcastMessage("Personaunshooter is enabled and runs on High Priority");
            }
            else
            {
                if(getConfig().getBoolean(pathprioNormal))
                {
                    getServer().getPluginManager().registerEvents(new ArrowListenerNORMAL(), this);
                    Bukkit.broadcastMessage("Personaunshooter is enabled and runs on Normal Priority");
                }
                else
                {
                    Bukkit.broadcastMessage("Personaunshooter is disabled, go into config file and set one Priority to true if you want to change that.");
                }
            }
        }
    }
    public void loadConfig()
    {
        getConfig().addDefault(pathprioNormal, true);
        getConfig().addDefault(pathprioHigh, false);
        getConfig().addDefault(pathprioHighest, false);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
