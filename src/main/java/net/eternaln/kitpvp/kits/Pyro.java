package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Pyro extends Kit {
	
	public Pyro() {
		permission = "kitpvp.pyro";

		lore = new String[] {
				"&6&lCOSAS",
				"",
				" &7- &fEspada llameante 1",
				" &7- &fArco de llamas 1",
				" &7- &f2 manzanas doradas",
				" &7- &f32 flechas",
				" &7- &7Casco de oro",
				" &7- &fPechera de oro Protección 2",
				" &7- &fPantalones de oro",
				" &7- &fZapatos de oro",
				" &7- &fProtección contra el fuego 1 permanente"
		};

		displayItem = new CItemStack(Material.FIREBALL).setName("&bPIROMANO").build();

		helm = new CItemStack(Material.GOLD_HELMET).makeUnbreakable().build();
		chest = new CItemStack(Material.GOLD_CHESTPLATE).makeUnbreakable()
				.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build();

		legs = new CItemStack(Material.GOLD_LEGGINGS).makeUnbreakable().build();
		boots = new CItemStack(Material.GOLD_BOOTS).makeUnbreakable().build();

		hotbar[0] = new CItemStack(Material.GOLD_SWORD).makeUnbreakable().addEnchantment(Enchantment.FIRE_ASPECT, 1)
				.setName("&6Espada llameante").build();

		hotbar[1] = new CItemStack(Material.BOW).makeUnbreakable().addEnchantment(Enchantment.ARROW_FIRE, 1)
				.setName("&6Arco de llamas").build();

		hotbar[7] = new CItemStack(Material.GOLDEN_APPLE, 2).build();
		hotbar[8] = new CItemStack(Material.ARROW, 32).build();

		addEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
	}
}
