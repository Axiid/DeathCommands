package it.axiid.deathcommands.plugin.listeners;

import it.axiid.deathcommands.plugin.DeathCommands;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerListener implements Listener {

    private final DeathCommands plugin;
    private final FileConfiguration config;

    public PlayerListener(DeathCommands plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if(config.getBoolean("instant-respawn"))
            Bukkit.getScheduler().runTaskLater(plugin, () -> player.spigot().respawn(), 1L);

        for(String command : config.getStringList("commands")) {
            player.performCommand(command);
        }
    }

}