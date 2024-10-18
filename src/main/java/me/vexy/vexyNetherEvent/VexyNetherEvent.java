package me.vexy.vexyNetherEvent;

import me.vexy.vexyNetherEvent.Listeners.PumpkinPlaceBlocker;
import me.vexy.vexyNetherEvent.Listeners.RandomDrop;
import org.bukkit.plugin.java.JavaPlugin;

public final class VexyNetherEvent extends JavaPlugin {

    private static VexyNetherEvent plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // Listeners
        getServer().getPluginManager().registerEvents(new RandomDrop(),  plugin);
        getServer().getPluginManager().registerEvents(new PumpkinPlaceBlocker(), plugin);
    }

    public static VexyNetherEvent getPlugin() {
        return plugin;
    }
}

