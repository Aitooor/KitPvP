package net.eternaln.kitpvp.event;

import net.eternaln.kitpvp.utils.Log;
import net.eternaln.kitpvp.utils.Utils;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import net.eternaln.kitpvp.KitManager;
import net.eternaln.kitpvp.Main;

public class SignInteraction implements Listener {

    FileConfiguration config = Main.instance.getConfig();

    String adminSingSetupName = config.getString("signs.admin-setup-name");

    String firstLine = config.getString("signs.lines.first-line");
    String secondLine = config.getString("signs.lines.second-line");
    String thirdLine = config.getString("signs.lines.third-line");
    String fourthLine = config.getString("signs.lines.fourth-line");

    public SignInteraction(){
        Log.info("Registered SignInteraction Event!");
    }

    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        if (e.getLine(0).equalsIgnoreCase(adminSingSetupName)) {
            e.setLine(0, Utils.tr(firstLine));
            e.setLine(1, Utils.tr(secondLine));
            e.setLine(2, Utils.tr(thirdLine));
            e.setLine(3, Utils.tr(fourthLine));
        }
    }

    @EventHandler
    public void onSignInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getState() instanceof Sign) {
            Sign s = (Sign) e.getClickedBlock().getState();
            if (s.getLine(0).contains(Utils.tr(firstLine)))
                KitManager.openKitSelection(e.getPlayer());
        } else if (e.getAction() == Action.LEFT_CLICK_BLOCK && e.getClickedBlock().getState() instanceof Sign) {
            Sign s = (Sign) e.getClickedBlock().getState();
            if (s.getLine(0).contains(Utils.tr(firstLine)))
                KitManager.openKitSelection(e.getPlayer());
        }
    }

}
