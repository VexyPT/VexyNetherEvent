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
            null, // Crate // Existe formas melhores de fazer isso
    };

    private final Random random = new Random(); // Não criar o random toda vez que o evento é chamado

    @EventHandler(ignoreCancelled = true) // outros plugins podem cancelar o evento e mesmo assim o código vai rodar
    public void onBlockBreak(BlockBreakEvent event) {
        Location blockLocation = event.getBlock().getLocation().toCenterLocation();
        World world = blockLocation.getWorld();

        if (world == null || world.getEnvironment() != World.Environment.NETHER) return;
        if (event.getBlock().getType() != Material.JACK_O_LANTERN) return;               // return early deixa o código mais limpo

        event.setDropItems(false);
        ItemStack drop = possibleDrops[random.nextInt(possibleDrops.length)];

        if (drop == null) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "excellentcrates dropkey chavehalloween " + blockLocation.getBlockX() + " " + blockLocation.getBlockY() + " " + blockLocation.getBlockZ() + " " + world.getName());
            return;
        }
        world.dropItemNaturally(blockLocation, drop);
    }

}
