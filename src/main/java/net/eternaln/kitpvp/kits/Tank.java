package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Tank extends Kit {
	public Tank() {
		price = 500;
        permission = "kitpvp.tank";

        lore = new String[]{
                "&6&lCOSAS",
                "",
                "&7- &fEspada de piedra",
                "&7- &fArmadura de diamante completo",
                "&7- &fLentitud permanente 2"
        };

        displayItem = new CItemStack(Material.DIAMOND_CHESTPLATE).setName("&bTANQUE").build();

        helm = new CItemStack(Material.DIAMOND_HELMET).makeUnbreakable().build();
        chest = new CItemStack(Material.DIAMOND_CHESTPLATE).makeUnbreakable().build();
        legs = new CItemStack(Material.DIAMOND_LEGGINGS).makeUnbreakable().build();
        boots = new CItemStack(Material.DIAMOND_BOOTS).makeUnbreakable().build();

        hotbar[0] = new CItemStack(Material.STONE_SWORD).makeUnbreakable().build();

        addEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1));
	}
}
