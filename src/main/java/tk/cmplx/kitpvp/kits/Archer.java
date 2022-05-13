package tk.cmplx.kitpvp.kits;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tk.cmplx.kitpvp.utils.CItemStack;
import tk.cmplx.kitpvp.utils.CLeatherArmor;
import tk.cmplx.kitpvp.utils.CPotion;
import tk.cmplx.kitpvp.utils.Kit;

public class Archer extends Kit {
	public Archer() {
		lore = new String[] {
				"&6&lCOSAS",
				"&r",
				"&7- &fEspada de madera Filo 1",
				"&7- &fFuerza 1&7, &fGolpeo 1&7, &fInfinito",
				"&7- &fPoción de curación arrojadiza",
				"&7- &fCasco de cuero",
				"&7- &fPechera de malla",
				"&7- &fPantalones de cuero",
				"&7- &fBotas de cuero",
				"&7- &fVelocidad 1 PERMANENTE"
		};

		displayItem = new CItemStack(Material.BOW).setName("&bARQUERO").build();
		helm = new CLeatherArmor(Material.LEATHER_HELMET).color(Color.GREEN).makeUnbreakable().build();
		chest = new CItemStack(Material.CHAINMAIL_CHESTPLATE).makeUnbreakable().build();
		legs = new CLeatherArmor(Material.LEATHER_LEGGINGS).color(Color.GREEN).makeUnbreakable().build();
		boots = new CLeatherArmor(Material.LEATHER_BOOTS).color(Color.GREEN).makeUnbreakable().build();
		hotbar[0] = new CItemStack(Material.WOOD_SWORD).makeUnbreakable().build();
		hotbar[1] = new CItemStack(Material.BOW).makeUnbreakable()
				.addEnchantment(Enchantment.ARROW_INFINITE, 1)
				.addEnchantment(Enchantment.ARROW_DAMAGE, 1)
				.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1).build();
		hotbar[7] = new CPotion().addInstantEffect(true).splash().build();
		hotbar[8] = new CItemStack(Material.ARROW).setName("&eFlecha legendaria").build();
		addEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));

	}

}
