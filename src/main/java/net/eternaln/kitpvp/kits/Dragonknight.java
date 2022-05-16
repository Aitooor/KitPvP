package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.CPotion;
import net.eternaln.kitpvp.utils.Kit;
import net.eternaln.kitpvp.utils.Utils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class Dragonknight extends Kit {
	public Dragonknight() {
        permission = "kitpvp.dragonknight";

		price = 20000;

        lore = new String[]{
				"&6&lCOSAS",
				"",
				" &7- &fEl poder dracónico"
        };

        displayItem = new CItemStack(Material.BLAZE_POWDER).setName("&bSANGRE DE DRAGON").build();
        helm = new CItemStack(Material.GOLD_HELMET)
                .makeUnbreakable()
                .addEnchantment(Enchantment.PROTECTION_FIRE, 1)
                .addEnchantment(Enchantment.PROTECTION_PROJECTILE, 5)
                .addEnchantment(Enchantment.THORNS, 2)
                .build();
        chest = new CItemStack(Material.IRON_CHESTPLATE).makeUnbreakable().build();
        legs = new CItemStack(Material.CHAINMAIL_LEGGINGS).makeUnbreakable().build();
        boots = new CItemStack(Material.CHAINMAIL_BOOTS).makeUnbreakable().build();

        hotbar[0] = new CItemStack(Material.STONE_SWORD).makeUnbreakable().build();
        hotbar[1] = new CItemStack(Material.BOW)
											.makeUnbreakable()
											.addEnchantment(Enchantment.ARROW_FIRE, 1)
											.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1)
											.setName("&aArco del maestro").build();
        hotbar[2] = new CItemStack(Material.BLAZE_POWDER, 2).setName("&cSangre de dragón").build();
        hotbar[3] = new CPotion().setType(PotionType.FIRE_RESISTANCE)
								.addPotionEffect(PotionEffectType.ABSORPTION,1,16)
								.addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE,25)
								.addPotionEffect(PotionEffectType.FIRE_RESISTANCE,16)
								.setAmt(2)
								.setName("&6Bebida de lava")
								.build();
        hotbar[8] = new CItemStack(Material.ARROW, 3).setName("&8Flecha mortal").build();

        addEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 0));
	}

	PotionEffect[] dragonblood = {
		new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 60, 0),
		new PotionEffect(PotionEffectType.SPEED, 200, 0),
		new PotionEffect(PotionEffectType.HEALTH_BOOST, 140, 1),
		new PotionEffect(PotionEffectType.HEAL, 1, 10)
	};

	@Override
	public void onItemUse(PlayerInteractEvent event, Player p, ItemStack item) {
		if(item.getType() != Material.BLAZE_POWDER) return;

		if(Utils.consumeItem(item)) p.setItemInHand(AIR.clone());

		for (PotionEffect pot : dragonblood) {
			if (p.hasPotionEffect(pot.getType())) p.removePotionEffect(pot.getType());
			p.addPotionEffect(pot);
		}

	}

	PotionEffect[] dkArrow = {
		new PotionEffect(PotionEffectType.SLOW, 60, 254),
		new PotionEffect(PotionEffectType.JUMP, 60, 254),
		new PotionEffect(PotionEffectType.BLINDNESS, 60, 1),
		new PotionEffect(PotionEffectType.WEAKNESS, 60, 1)
	};

	@Override
	public void onDamageDeal(EntityDamageByEntityEvent event, Player dealer, Player receiver) {
		if(event.getDamager() instanceof Arrow) {
			for(PotionEffect eff : dkArrow) {
				receiver.addPotionEffect(eff);
			}
		}
	}

}
