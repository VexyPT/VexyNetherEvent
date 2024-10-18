package me.vexy.vexyNetherEvent.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class RandomDrop implements Listener {

    private final ItemStack[] possibleDrops = {
            new ItemStack(Material.DIAMOND, 1),
            new ItemStack(Material.EMERALD, 1),
            new ItemStack(Material.GOLD_INGOT, 1),
            new ItemStack(Material.IRON_INGOT, 1),
            new ItemStack(Material.APPLE, 1), // Crate
    };

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Location blockLocation = event.getBlock().getLocation();
        World world = blockLocation.getWorld();

        if (world != null && world.getEnvironment() == World.Environment.NETHER) {
            if(event.getBlock().getType() == Material.CARVED_PUMPKIN) {
                event.setDropItems(false);

                Random random = new Random();
                ItemStack drop = possibleDrops[random.nextInt(possibleDrops.length)];

                if (drop.getType() == Material.APPLE) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "excellentcrates dropkey chavehalloween " + blockLocation.getBlockX() + " " + blockLocation.getBlockY() + " " + blockLocation.getBlockZ());
                } else {
                    world.dropItemNaturally(blockLocation, drop);
                }
            }
        }

    }
}
