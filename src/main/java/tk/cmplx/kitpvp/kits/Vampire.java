package tk.cmplx.kitpvp.kits;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import tk.cmplx.kitpvp.utils.CItemStack;
import tk.cmplx.kitpvp.utils.CLeatherArmor;
import tk.cmplx.kitpvp.utils.CPotion;
import tk.cmplx.kitpvp.utils.Kit;

public class Vampire extends Kit {
	public Vampire() {
        price = 5000;
        permission = "kitpvp.vampire";

        lore = new String[]{
				"&6&lCOSAS",
				"",
				"&7- &fBastón de robo de vida",
				"&7- &fCapa del Vampiro",
				"&7- &f2x mara sangrienta",
				"&7- &fVisión nocturna permanente"
        };

        displayItem = new CItemStack(Material.STICK).setName("&cVampir").build();

        hotbar[0] = new CItemStack(Material.STICK).setName("&cBastón de robo de vida").addEnchantment(Enchantment.DAMAGE_ALL, 1).build();

        chest = new CLeatherArmor(Material.LEATHER_CHESTPLATE).color(Color.PURPLE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).makeUnbreakable().build();

        hotbar[8] = new CPotion().setType(PotionType.STRENGTH)
                .addPotionEffect(PotionEffectType.REGENERATION, 30)
                .addPotionEffect(PotionEffectType.BLINDNESS, 2)
                .setName("&cMara sangrienta").setAmt(2).build();

        addEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 2));
	}

	@Override
	public void onDamageDeal(EntityDamageByEntityEvent event, Player dealer, Player receiver) {
		if(dealer.getItemInHand().getType() != Material.STICK) return;

		int healingFactor = 3;

		if(dealer.getHealth() + healingFactor > dealer.getMaxHealth())
			dealer.setHealth(dealer.getMaxHealth());
		else
			dealer.setHealth(dealer.getHealth() + healingFactor);

		if (!(receiver.getHealth() - (healingFactor + 1) < 0))
			receiver.setHealth(receiver.getHealth() - (healingFactor + 1));
	}

}
