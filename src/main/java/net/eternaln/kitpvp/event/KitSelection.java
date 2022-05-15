package net.eternaln.kitpvp.event;

import net.eternaln.kitpvp.KitManager;
import net.eternaln.kitpvp.Main;
import net.eternaln.kitpvp.utils.Kit;
import net.eternaln.kitpvp.utils.Log;
import net.eternaln.kitpvp.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class KitSelection implements Listener {

	public KitSelection() {
		Log.info("Registered KitSelection Event!");
	}

	@EventHandler
	public void onKitSelect(InventoryClickEvent e) {

		Player p = (Player) e.getWhoClicked();
		ItemStack c = e.getCurrentItem();
		Inventory i = e.getInventory();

		if (c == null || c.getType() == Material.AIR) return;
		if (!i.getName().contains(ChatColor.BLACK + "SELECTOR DE KITS")) return;

		e.setCancelled(true);

		Kit k = KitManager.kits[e.getRawSlot()];

		if (p.hasPermission(k.permission)) {

			if (!p.hasPermission("kitpvp.bypasscooldown")) {
				Long lastSelected = Utils.getMetadata(p, "kitpvp.lastSelected", Long.class);
				long cooldown = System.currentTimeMillis() - (lastSelected == null ? 0 : lastSelected);
				if (cooldown < 30000) {
					int wait = (int) ((30000 - cooldown) / 1000);
					Utils.msg(p, "&cTodavía tienes que esperar &b" + wait + " &csegundos!");
					return;
				}
			}

			Utils.msg(p, "&aSeleccionado &f" + c.getItemMeta().getDisplayName());
			p.playSound(p.getLocation(), Sound.ORB_PICKUP, 3, 1);
			p.closeInventory();

			k.applyKit(p);
			Utils.putMetadata(p, "kitpvp.lastSelected", System.currentTimeMillis());

			for (Player online : Bukkit.getOnlinePlayers())
				online.showPlayer(p);

		} else {

			if (e.getClick() == ClickType.RIGHT) {
				if (Main.economyHook && Main.permissionHook) {
					if (k.buyable) {
						if (Main.instance.econ.getBalance(p) >= k.price) {

							Main.instance.econ.withdrawPlayer(p, k.price);
							Main.instance.perms.playerAdd(null, p, k.permission);

							Utils.msg(p, "&aHas comprado el KIT &b" + c.getItemMeta().getDisplayName()
									+ "&a ¡Muchas gracias!");

							p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 0.8F);
							p.closeInventory();
							return;
						} else {
							p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, 1);
							Utils.msg(p, "&cNo tienes suficiente dinero para el KIT &b" + c.getItemMeta().getDisplayName());
							return;
						}
					} else {
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, 1);
						Utils.msg(p, "&c¡No puedes comprar este kit!");
						return;
					}
				}
			}
			Utils.msg(p, "&cSin derecho al KIT &b" + c.getItemMeta().getDisplayName());
		}

	}

}
