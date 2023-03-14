package it.axiid.deathcommands.plugin.commands;

import it.axiid.deathcommands.plugin.DeathCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    private final DeathCommands plugin;

    public MainCommand(DeathCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 1) {
            sender.sendMessage("§7Running §4DeathCommands §7version §c" + plugin.getDescription().getVersion());
            sender.sendMessage("§7Created by §eAxiid");
            return false;
        }

        if(args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            plugin.saveConfig();

            sender.sendMessage("§aPlugin reloaded.");
        }

        sender.sendMessage("§cInvalid argument.");
        return true;
    }

}