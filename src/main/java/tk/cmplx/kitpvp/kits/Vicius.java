package tk.cmplx.kitpvp.kits;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tk.cmplx.kitpvp.utils.CItemStack;
import tk.cmplx.kitpvp.utils.CLeatherArmor;
import tk.cmplx.kitpvp.utils.Kit;
import tk.cmplx.kitpvp.utils.Utils;

public class Vicius extends Kit {
	public Vicius() {
        price = 4000;
        permission = "kitpvp.drugaddict";

        lore = new String[]{
				"&6&lCOSAS",
				"",
				"&7- &fBotella de vidrio rota",
				"&7- &fPantalones rotos",
				"&7- &f5 gramos de cocaina"
        };

        displayItem = new CItemStack(Material.SUGAR).setName("&bVICIOSO").build();

        hotbar[0] = new CItemStack(Material.GLASS_BOTTLE).setName("&8Botella rota").makeUnbreakable().addEnchantment(Enchantment.DAMAGE_ALL, 5).build();

        legs = new CLeatherArmor(Material.LEATHER_LEGGINGS).color(Color.BLACK).makeUnbreakable().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8).build();

        hotbar[1] = new CItemStack(Material.SUGAR).setAmt(5).setName("&bAzucar").build();
	}

	PotionEffect[] cocain = {
		new PotionEffect(PotionEffectType.SPEED, 100, 2),
		new PotionEffect(PotionEffectType.REGENERATION, 100, 1),
		new PotionEffect(PotionEffectType.CONFUSION, 140, 0)
	};

	@Override
	public void onItemUse(PlayerInteractEvent event, Player p, ItemStack item) {
		if(item.getType() != Material.SUGAR) return;

		if(Utils.consumeItem(item)) p.setItemInHand(AIR.clone());

		for (PotionEffect pot : cocain) {
			if (p.hasPotionEffect(pot.getType())) p.removePotionEffect(pot.getType());
			p.addPotionEffect(pot);
		}

	}

}
