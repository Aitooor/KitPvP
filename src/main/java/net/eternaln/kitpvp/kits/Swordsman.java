package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Material;

public class Swordsman extends Kit {

	public Swordsman() {
		permission = "kitpvp.swordsman";

		lore = new String[] {
				"&6&lCOSAS",
				"",
				" &7- &fArmadura de Hierro",
				" &7- &fEspada de diamante",
				" &7- &f2 manzanas doradas"
		};

		displayItem = new CItemStack(Material.DIAMOND_SWORD).setName("&bESPADACHIN").build();

		helm = new CItemStack(Material.IRON_HELMET).makeUnbreakable().build();
		chest = new CItemStack(Material.IRON_CHESTPLATE).makeUnbreakable().build();
		legs = new CItemStack(Material.IRON_LEGGINGS).makeUnbreakable().build();
		boots = new CItemStack(Material.IRON_BOOTS).makeUnbreakable().build();

		hotbar[0] = new CItemStack(Material.DIAMOND_SWORD).makeUnbreakable().build();
		hotbar[1] = new CItemStack(Material.GOLDEN_APPLE, 2).build();

	}

}
