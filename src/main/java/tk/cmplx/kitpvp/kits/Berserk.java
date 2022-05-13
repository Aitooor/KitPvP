package tk.cmplx.kitpvp.kits;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tk.cmplx.kitpvp.utils.CItemStack;
import tk.cmplx.kitpvp.utils.CLeatherArmor;
import tk.cmplx.kitpvp.utils.Kit;

public class Berserk extends Kit {
	public Berserk() {
		permission = "kitpvp.berserk";
		price = 5500;

		lore = new String[] {
				"&6&lCOSAS",
				"&r",
				"&7- &fEspada de hierro",
				"&7- &fPechera de cuero",
				"&7- &fFuerza 1 Permanente"
		};

		displayItem = new CItemStack(Material.IRON_SWORD).setName("&bENLOQUEZIDO").build();
		chest = new CLeatherArmor(Material.LEATHER_CHESTPLATE).color(Color.RED).makeUnbreakable().build();

		hotbar[0] = new CItemStack(Material.IRON_SWORD).makeUnbreakable().build();

		addEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
	}
}
