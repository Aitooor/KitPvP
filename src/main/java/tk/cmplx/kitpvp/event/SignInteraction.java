package tk.cmplx.kitpvp.event;

import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import tk.cmplx.kitpvp.KitManager;
import tk.cmplx.kitpvp.utils.Log;
import tk.cmplx.kitpvp.utils.Utils;

public class SignInteraction implements Listener {

    public SignInteraction(){
        Log.info("Registered SignInteraction Event!");
    }

    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        if (e.getLine(0).equalsIgnoreCase("[kitpvp]")) {
            e.setLine(0, Utils.tr("&0&lKitPvP"));
            e.setLine(1, Utils.tr("&7Elige tu &lKIT"));
            e.setLine(2, Utils.tr(""));
            e.setLine(3, Utils.tr("&0Click para elegir"));
        }
    }

    @EventHandler
    public void onSignInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_BLOCK && e.getClickedBlock().getState() instanceof Sign || e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getState() instanceof Sign) {
            Sign s = (Sign) e.getClickedBlock().getState();
            if (s.getLine(0).contains(Utils.tr("&0&lKitPvP")))
				KitManager.openKitSelection(e.getPlayer());
        }
    }

}
