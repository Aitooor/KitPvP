package tk.cmplx.kitpvp.kits;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tk.cmplx.kitpvp.utils.CItemStack;
import tk.cmplx.kitpvp.utils.CLeatherArmor;
import tk.cmplx.kitpvp.utils.Kit;

public class Snowman extends Kit {
	public Snowman() {
		permission = "kitpvp.snowman";
		price = 5000;

		lore = new String[] {
				"&6&lCOSAS",
				"",
				"&7- &fNitidez de espada de piedra 1",
				"&7- &f64 bolas de nieve",
				"&7- &fArmadura de cuero completa",
				"&7- &fLas bolas de nieve ralentizan cuando golpeas",
				"&7- &fLas bolas de nieve curan al golpearse durante un tiempo corto",
				"&7- &fVelocidad permanente 1"

		};

		displayItem = new CItemStack(Material.SNOW_BALL).setName("&bMUÑECO DE NIEVE").build();
		helm = new CLeatherArmor(Material.LEATHER_HELMET).color(Color.WHITE).makeUnbreakable().build();
		chest = new CLeatherArmor(Material.LEATHER_CHESTPLATE).color(Color.WHITE).makeUnbreakable().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build();
		legs = new CLeatherArmor(Material.LEATHER_LEGGINGS).color(Color.WHITE).makeUnbreakable().build();
		boots = new CLeatherArmor(Material.LEATHER_BOOTS).color(Color.WHITE).makeUnbreakable().build();

		hotbar[0] = new CItemStack(Material.STONE_SWORD).makeUnbreakable().addEnchantment(Enchantment.DAMAGE_ALL, 1).build();
		hotbar[1] = new CItemStack(Material.SNOW_BALL, 64).build();

		addEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
	}

	@Override
	public void onDamageDeal(EntityDamageByEntityEvent e, Player dealer, Player receiver) {
		if (e.getDamager() instanceof Snowball) {
			dealer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 2));
			receiver.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 2));
		}
	}

}
