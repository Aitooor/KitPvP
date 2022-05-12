package tk.cmplx.kitpvp.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.cmplx.kitpvp.Main;

public class Reload implements CommandExecutor {

    private final Main plugin;

    public Reload(Main instance) {
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
