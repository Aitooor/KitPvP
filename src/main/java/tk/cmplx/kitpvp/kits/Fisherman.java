package tk.cmplx.kitpvp.kits;

import org.bukkit.Material;

import tk.cmplx.kitpvp.utils.CItemStack;
import tk.cmplx.kitpvp.utils.Kit;

public class Fisherman extends Kit{
	public Fisherman() {
        permission = "kitpvp.rod";
        price = 1250;

        lore = new String[]{
                "&6&lCOSAS",
                "",
                "&7- &fEspada de hierro",
                "&7- &fCaña de pescar",
                "&7- &f2 manzanas doradas",
                "&7- &fCasco de cota de malla",
                "&7- &fPechera de cuero",
                "&7- &fPantalones de cota de malla",
                "&7- &fBotas de cota de malla"
        };

        displayItem = new CItemStack(Material.FISHING_ROD).setName("&bPESCADOR").build();

        helm = new CItemStack(Material.CHAINMAIL_HELMET).makeUnbreakable().build();
        chest = new CItemStack(Material.LEATHER_CHESTPLATE).makeUnbreakable().build();
        legs = new CItemStack(Material.CHAINMAIL_LEGGINGS).makeUnbreakable().build();
        boots = new CItemStack(Material.CHAINMAIL_BOOTS).makeUnbreakable().build();

        hotbar[0] = new CItemStack(Material.IRON_SWORD).makeUnbreakable().build();
        hotbar[1] = new CItemStack(Material.FISHING_ROD).makeUnbreakable().build();
        hotbar[8] = new CItemStack(Material.GOLDEN_APPLE, 2).build();
	}
}
