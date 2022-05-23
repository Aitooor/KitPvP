package net.eternaln.kitpvp.cmd;

import net.eternaln.kitpvp.KitManager;
import net.eternaln.kitpvp.Main;
import net.eternaln.kitpvp.utils.Kit;
import net.eternaln.kitpvp.utils.LocationUtil;
import net.eternaln.kitpvp.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
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

        if(args[0].equalsIgnoreCase("setspawn")) {
            if (!player.hasPermission("kitpvp.setspawn")) {
                player.sendMessage("§cYou don't have permission to do that.");
            } else {
                Main.instance.getConfig().set("LOCATION.SPAWN", LocationUtil.parseToString(player.getLocation()));
                plugin.saveConfig();
                plugin.reloadConfig();

                player.sendMessage(Utils.ct("&b&lKitPvP &aEl spawn se ha establecido"));
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            }
        }

        return false;
    }
}
