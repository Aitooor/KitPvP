package tk.cmplx.kitpvp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.md_5.bungee.api.ChatColor;
import tk.cmplx.kitpvp.kits.*;
import tk.cmplx.kitpvp.utils.CItemStack;
import tk.cmplx.kitpvp.utils.Kit;

public class KitManager {

	public static final Kit[] kits = {
			new Swordsman(),
			new Barbar(),
			new Archer(),
			new Pyro(),
			new Tank(),

			new Snowman(),
			new Fisherman(),
			new Witch(),
			new Rabbit(),
			new Berserker(),
			new Housewife(),
			new Berserk(),
			new Soup(),
			new Templar(),
			new Mage(),
			new Supporter(),
			new Onehit(),
			new Skeleton(),
			new Vampire(),
			new Wither(),
			new Vicius(),

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
						lore.add(0, ChatColor.GOLD + "Precio " + ChatColor.YELLOW + k.price);
						lore.add(0, ChatColor.AQUA + "¡Compra con clic derecho!");
					} else if (k.dropExclusive) {
						lore.add(0, ChatColor.RED + "¡No se puede comprar!");
						lore.add(0, ChatColor.AQUA + "¡Solo disponible como drop!");
					} else {
						lore.add(0, ChatColor.RED + "¡No se puede comprar!");
						lore.add(0, ChatColor.LIGHT_PURPLE + "¡Exclusivo para VIP!");
					}
				}
			} else
				lore.add(0, ChatColor.GREEN + "¡Ya comprado!");

			dummy.setItem(slot, displayItem.addLore(lore.toArray(new String[0])).build());
			slot++;
		}
		p.openInventory(dummy);
	}

}
