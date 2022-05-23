package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.CLeatherArmor;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Skeleton extends Kit {
	public Skeleton() {
        price = 3000;
        permission = "kitpvp.skeleton";

        maxHealth = 10;

        lore = new String[]{
                "&6&lCOSAS",
                "",
                " &7- &fMaza de huesos",
                " &7- &fArmadura de cuero Blanco Hueso",
                " &7- &fResistencia y Velocidad Permanentes",
                " &7- &f5 corazones permanentes"
        };

        displayItem = new CItemStack(Material.BONE).setName("&bESQUELETO").build();

        hotbar[0] = new CItemStack(Material.BONE).setName("&7Maza de huesos").addEnchantment(Enchantment.DAMAGE_ALL, 5).build();
        boots = new CLeatherArmor(Material.LEATHER_BOOTS).color(Color.WHITE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).makeUnbreakable().build();
        legs = new CLeatherArmor(Material.LEATHER_LEGGINGS).color(Color.WHITE)
                .addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3)
                .addEnchantment(Enchantment.DEPTH_STRIDER, 1)
                .makeUnbreakable().build();
        chest = new CLeatherArmor(Material.LEATHER_CHESTPLATE).color(Color.WHITE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).makeUnbreakable().build();
        helm = new CItemStack(Material.SKULL_ITEM).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).makeUnbreakable().build();

        addEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 2));
        addEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1));
        addEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
	}
}
