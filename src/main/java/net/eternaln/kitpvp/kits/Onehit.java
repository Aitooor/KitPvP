package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.CLeatherArmor;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Onehit extends Kit {
	public Onehit() {
        price = 15000;
        permission = "kitpvp.onehit";

        maxHealth = 2;

        lore = new String[]{
                "&6&lCOSA",
                "",
                " &7- &fMata o muere ;)"
        };

        displayItem = new CItemStack(Material.SPECKLED_MELON).setName("&bUN GOLPE").build();

        hotbar[0] = new CItemStack(Material.GOLD_SWORD).makeUnbreakable().setName("&6Rompedor del crepúsculo").addEnchantment(Enchantment.DAMAGE_ALL, 10).build();
        boots = new CLeatherArmor(Material.LEATHER_BOOTS).color(Color.RED).addEnchantment(Enchantment.PROTECTION_FALL, 10).makeUnbreakable().build();

        addEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 100));
	}
}
