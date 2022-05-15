package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.CPotion;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Rabbit extends Kit {
	public Rabbit() {
        permission = "kitpvp.rabbit";
        price = 2650;

        lore = new String[]{
                "&6&lCOSAS",
                "",
                "&7- &fEspada de piedra",
                "&7- &fArmadura de malla completa",
                "&7- &fEstuche de plumas X Zapatos",
                "&7- &f1 poción curativa arrojadiza",
                "&7- &fRebote permanente",
                "&7- &fVelocidad permanente"
        };

        displayItem = new CItemStack(Material.RABBIT_FOOT).setName("&bCONEJO").build();

        helm = new CItemStack(Material.CHAINMAIL_HELMET).makeUnbreakable().build();
        chest = new CItemStack(Material.CHAINMAIL_CHESTPLATE).makeUnbreakable().build();
        legs = new CItemStack(Material.CHAINMAIL_LEGGINGS).makeUnbreakable().build();
        boots = new CItemStack(Material.CHAINMAIL_BOOTS).makeUnbreakable().addEnchantment(Enchantment.PROTECTION_FALL, 10).build();

        hotbar[0] = new CItemStack(Material.STONE_SWORD).makeUnbreakable().build();
        hotbar[1] = new CPotion().addInstantEffect(true, 1).splash().build();

        addEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1));
        addEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
	}
}
