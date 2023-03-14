package it.axiid.deathcommands.plugin;

import it.axiid.deathcommands.provider.PluginProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathCommands extends JavaPlugin {

    private PluginProvider provider;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        provider = new PluginProvider(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}