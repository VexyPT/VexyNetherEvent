package me.vexy.vexyNetherEvent.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PumpkinPlaceBlocker implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if(event.getBlock().getType() == Material.CARVED_PUMPKIN) {
            if (player.hasPermission("brpacks.admin")) {
                event.setCancelled(true);
                player.sendMessage("§cVocê não pode colocar esse bloco.");
            }
        }
    }
}
