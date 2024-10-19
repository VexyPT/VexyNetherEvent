package me.vexy.vexyNetherEvent.Listeners;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PumpkinPlaceBlocker implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (event.getBlock().getType() != Material.JACK_O_LANTERN) return;
        if (!event.getBlock().getWorld().getEnvironment().equals(World.Environment.NETHER)) return;
        if (player.hasPermission("brpacks.admin")) return;
        event.setCancelled(true);
        player.sendMessage("§cVocê não pode colocar esse bloco.");
    }
}
