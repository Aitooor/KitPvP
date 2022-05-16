package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.CPotion;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Templar extends Kit {
	public Templar() {

        permission = "kitpvp.templar";
        price = 3750;

       	lore = new String[]{
                "&6&lCOSAS",
                "",
                " &7- &fEspada de hierro",
                " &7- &fPechera de Hierro Protección 1",
                " &7- &f2 pociones de salud arrojadizas",
                " &7- &f14 corazones de oro extra"
        };

        displayItem = new CItemStack(Material.GOLDEN_APPLE).setName("&bTEMPLARIO").build();

        chest = new CItemStack(Material.IRON_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).makeUnbreakable().build();

        hotbar[0] = new CItemStack(Material.IRON_SWORD).makeUnbreakable().build();
        hotbar[8] = new CPotion().addInstantEffect(true).splash().setAmt(2).build();

        addEffect(new PotionEffect(PotionEffectType.ABSORPTION, Integer.MAX_VALUE, 6));
	}
}
