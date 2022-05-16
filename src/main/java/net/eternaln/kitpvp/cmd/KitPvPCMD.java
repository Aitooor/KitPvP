package net.eternaln.kitpvp.cmd;

import net.eternaln.kitpvp.KitManager;
import net.eternaln.kitpvp.Main;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitPvPCMD implements CommandExecutor {

    Kit k = KitManager.kits[0];

    private final Main plugin;

    public KitPvPCMD(Main instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
        if (args.length == 0) return false;

        Player player = (Player) sender;
        if(args[0].equalsIgnoreCase("reload")) {
            if (!player.hasPermission("kitpvp.reload")) {
                player.sendMessage("§cYou don't have permission to do that.");
            } else {
                plugin.reloadConfig();
                player.sendMessage("§b§lKitPvP §fConfig reloaded.");
            }
        }

        return false;
    }
}
