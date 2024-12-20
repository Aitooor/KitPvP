package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.CLeatherArmor;
import net.eternaln.kitpvp.utils.CPotion;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class Wither extends Kit {
	public Wither() {
        price = 4000;
        permission = "kitpvp.wither";

        lore = new String[]{
                "&6&lCOSAS",
                "",
                " &7- &fEspada del Wither",
                " &7- &f2 Poción de ceguera",
                " &7- &fVisión nocturna permanente"
        };

        displayItem = new CItemStack(Material.SKULL_ITEM).setDurability(1).setName("&bWITHER").build();

        hotbar[0] = new CItemStack(Material.STONE_SWORD).setName("&8Espada del Wither").makeUnbreakable().addEnchantment(Enchantment.DAMAGE_ALL, 2).build();
        boots = new CLeatherArmor(Material.LEATHER_BOOTS).color(Color.BLACK).makeUnbreakable().build();
        legs = new CLeatherArmor(Material.LEATHER_LEGGINGS).color(Color.BLACK).makeUnbreakable().build();
        chest = new CLeatherArmor(Material.LEATHER_CHESTPLATE).color(Color.BLACK).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).makeUnbreakable().build();
        helm = new CItemStack(Material.SKULL_ITEM).setDurability(1).makeUnbreakable().build();

        hotbar[1] = new CPotion().setType(PotionType.STRENGTH)
                .addPotionEffect(PotionEffectType.BLINDNESS, 2).splash()
                .setName("&4Poción de ceguera").setAmt(2).build();

        addEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 2));
	}

	@Override
	public void onDamageDeal(EntityDamageByEntityEvent event, Player dealer, Player receiver) {
		if(dealer.getItemInHand().getType() == Material.STONE_SWORD)
			receiver.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
	}

}
