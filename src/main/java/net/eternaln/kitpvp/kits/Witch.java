package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.CLeatherArmor;
import net.eternaln.kitpvp.utils.CPotion;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class Witch extends Kit {
	public Witch() {
        permission = "kitpvp.witch";
        price = 3250;

        lore = new String[]{
                "&6&lCOSAS",
                "",
                " &7- &fEspada de piedra",
                " &7- &fArmadura de cuero completa",
                " &7- &f2 pociones debilitantes arrojadizas",
                " &7- &fPoción de lentitud arrojadiza",
                " &7- &fPoción de veneno arrojadiza",
                " &7- &fPoción curativa"
        };

        displayItem = new CItemStack(Material.SPIDER_EYE).setName("&bBRUJA").build();
        helm = new CLeatherArmor(Material.LEATHER_HELMET).color(Color.GRAY).makeUnbreakable().build();
        chest = new CLeatherArmor(Material.LEATHER_CHESTPLATE).color(Color.GRAY).makeUnbreakable()
                .addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3)
                .addEnchantment(Enchantment.THORNS, 3).build();
        legs = new CLeatherArmor(Material.LEATHER_LEGGINGS).color(Color.GRAY).makeUnbreakable().build();
        boots = new CLeatherArmor(Material.LEATHER_BOOTS).color(Color.GRAY).makeUnbreakable().build();

        hotbar[0] = new CItemStack(Material.STONE_SWORD).makeUnbreakable().build();
        hotbar[1] = new CPotion().addPotionEffect(PotionEffectType.WEAKNESS, 120).setType(PotionType.WEAKNESS).splash().setAmt(2).build();
        hotbar[2] = new CPotion().addPotionEffect(PotionEffectType.SLOW, 30).setType(PotionType.SLOWNESS).splash().build();
        hotbar[3] = new CPotion().addPotionEffect(PotionEffectType.POISON, 30).setType(PotionType.POISON).splash().build();
        hotbar[4] = new CPotion().addInstantEffect(true, 1).build();
	}
}
