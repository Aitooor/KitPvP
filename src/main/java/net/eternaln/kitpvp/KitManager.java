package net.eternaln.kitpvp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.eternaln.kitpvp.kits.*;
import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.md_5.bungee.api.ChatColor;

public class KitManager {

	public static final Kit[] kits = {
			new Swordsman(),
			new Barbar(),
			new Archer(),
			new Pyro(),

			new Tank(),
			new Fisherman(),
			new Dressmaker(),
			new Supporter(),
			new Rabbit(),
			new Berserker(),
			new Skeleton(),
			new Witch(),
			new Soup(),
			new Templar(),
			new Vicius(),
			new Wither(),
			new Mage(),
			new Snowman(),
			new Vampire(),
			new Berserk(),

			new Onehit(),
			new Ghost(),
			new Ender(),
			new Dragonknight()
	};

	public static void openKitSelection(Player p) {
		Inventory dummy = Bukkit.createInventory(null, 9 * (int) Math.ceil(KitManager.kits.length / 9.0), ChatColor.BLACK + "SELECTOR DE KITS");

		int slot = 0;
		for (Kit k : KitManager.kits) {

			CItemStack displayItem = new CItemStack(k.displayItem.clone());
			List<String> lore = new ArrayList<>(Arrays.asList(k.lore));

			if (!p.hasPermission(k.permission)) {
				if (Main.economyHook && Main.permissionHook) {
					if (k.buyable) {
						lore.add(0, ChatColor.RED + "¡No comprado!");
						lore.add(0, ChatColor.GRAY + "Precio " + ChatColor.YELLOW + k.price);
						lore.add(0, ChatColor.GREEN + "¡Compra con clic derecho!");
					} else if (k.dropExclusive) {
						lore.add(0, ChatColor.RED + "¡No se puede comprar!");
						lore.add(0, ChatColor.GREEN + "¡Solo disponible como drop!");
					} else {
						lore.add(0, ChatColor.RED + "¡No se puede comprar!");
						lore.add(0, ChatColor.GREEN + "¡Exclusivo para VIP!");
					}
				}
			} else
				lore.add(0, ChatColor.GREEN + "¡Ya obtenido!");

			dummy.setItem(slot, displayItem.addLore(lore.toArray(new String[0])).build());
			slot++;
		}
		p.openInventory(dummy);
	}

}
