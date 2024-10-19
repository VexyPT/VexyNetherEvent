package me.vexy.vexyNetherEvent;

import me.vexy.vexyNetherEvent.Listeners.PumpkinPlaceBlocker;
import me.vexy.vexyNetherEvent.Listeners.RandomDrop;
import org.bukkit.plugin.java.JavaPlugin;

public final class VexyNetherEvent extends JavaPlugin {

    private static VexyNetherEvent instance;

    @Override
    public void onEnable() {
        instance = this;

        // Listeners
        getServer().getPluginManager().registerEvents(new RandomDrop(),  this);
        getServer().getPluginManager().registerEvents(new PumpkinPlaceBlocker(), this);
    }

    public static VexyNetherEvent get() {
        return instance;
    }
}