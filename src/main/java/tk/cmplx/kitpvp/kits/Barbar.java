package tk.cmplx.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import tk.cmplx.kitpvp.utils.CItemStack;
import tk.cmplx.kitpvp.utils.CPotion;
import tk.cmplx.kitpvp.utils.Kit;

public class Barbar extends Kit {
	public Barbar() {
		
        permission = "kitpvp.barbar";

        lore = new String[]{
                "&6&lCOSAS",
                "&r",
                "&7- &fHacha de piedra",
                "&7- &fPoción de regeneración de nivel 2",
                "&7- &fCasco de hierro",
                "&7- &fPechera de hierro",
                "&7- &fPantalones de hierro",
                "&7- &fBotas de cuero"
        };

        displayItem = new CItemStack(Material.STONE_AXE).setName("&bBARBARO").build();
        helm = new CItemStack(Material.IRON_HELMET).makeUnbreakable().build();
        chest = new CItemStack(Material.CHAINMAIL_CHESTPLATE).makeUnbreakable().build();
        legs = new CItemStack(Material.LEATHER_LEGGINGS).makeUnbreakable().build();
        boots = new CItemStack(Material.LEATHER_BOOTS).makeUnbreakable().build();
        hotbar[0] = new CItemStack(Material.STONE_AXE).makeUnbreakable().build();
        hotbar[1] = new CPotion().addPotionEffect(PotionEffectType.REGENERATION, 1, 20).setType(PotionType.REGEN).build();
	}
}
