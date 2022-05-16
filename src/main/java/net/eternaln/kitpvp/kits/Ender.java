package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.CLeatherArmor;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Ender extends Kit {
	public Ender() {
        permission = "kitpvp.ender";

        price = 20000;

        lore = new String[]{
                "&6&lCOSAS",
                "",
                " &7- &fEspada de piedra",
                " &7- &fCasco de cuero",
                " &7- &fPechera de hierro a prueba de balas 1",
                " &7- &f8 perlas ender",
                " &7- &fPantalones de cuero",
                " &7- &fBotas de hierro Caida Pluma 10",
                " &7- &fCura al golpear la enderpearl por un corto tiempo",
                " &7- &fVelocidad 1 permanente"
        };

        displayItem = new CItemStack(Material.ENDER_PEARL).setName("&bENDERMAN").build();

        helm = new CLeatherArmor(Material.LEATHER_HELMET).color(Color.BLACK).makeUnbreakable().build();
        chest = new CItemStack(Material.IRON_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1).makeUnbreakable().build();
        legs = new CLeatherArmor(Material.LEATHER_LEGGINGS).color(Color.BLACK).makeUnbreakable().build();
        boots = new CItemStack(Material.IRON_BOOTS).addEnchantment(Enchantment.PROTECTION_FALL, 10).makeUnbreakable().build();

        hotbar[0] = new CItemStack(Material.STONE_SWORD).makeUnbreakable().build();
        hotbar[1] = new CItemStack(Material.ENDER_PEARL, 16).build();
        hotbar[8] = new CItemStack(Material.GOLDEN_APPLE, 2).build();

        addEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
	}

	@Override
	public void onProjectileHit(ProjectileHitEvent e, Player p) {
		if(e.getEntityType() == EntityType.ENDER_PEARL)
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 50, 2));
	}

}
