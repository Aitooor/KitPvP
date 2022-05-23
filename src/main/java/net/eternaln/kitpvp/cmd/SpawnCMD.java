package net.eternaln.kitpvp.cmd;

import net.eternaln.kitpvp.Main;
import net.eternaln.kitpvp.utils.LocationUtil;
import net.eternaln.kitpvp.utils.Utils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {

    private final FileConfiguration config;

    private final Main plugin;

    public SpawnCMD(Main instance) {
        plugin = instance;

        this.config = plugin.getConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            if (args.length == 0) {
                Utils.log("¡Debes ser un usuario para usar esto!");
                return true;
            }
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            if((config.getString("LOCATION.SPAWN") == null)) {
                player.sendMessage(Utils.ct("&6&lETERNAL &cLlama a un &lSTAFF"));
            } else {
                player.teleport(LocationUtil.parseToLocation(config.getString("LOCATION.SPAWN")));
                player.sendMessage(Utils.ct("&6&lETERNAL &aTeletransportado al spawn"));
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            }

            return true;
        }
        return false;
    }

}
