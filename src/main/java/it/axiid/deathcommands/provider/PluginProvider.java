package it.axiid.deathcommands.provider;

import it.axiid.deathcommands.plugin.DeathCommands;
import it.axiid.deathcommands.plugin.commands.MainCommand;
import it.axiid.deathcommands.plugin.listeners.PlayerListener;

public class PluginProvider {

    private final DeathCommands plugin;

    public PluginProvider(DeathCommands plugin) {
        this.plugin = plugin;
        init();
    }

    private void init() {
        getCommands();
        getListeners();
    }

    private void getCommands() {
        plugin.getCommand("deathcommands").setExecutor(new MainCommand(plugin));
    }

    private void getListeners() {
        plugin.getServer().getPluginManager().registerEvents(new PlayerListener(plugin), plugin);
    }

}