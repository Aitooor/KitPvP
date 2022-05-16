package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.CLeatherArmor;
import net.eternaln.kitpvp.utils.CPotion;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Ghost extends Kit {
	public Ghost() {
        permission = "kitpvp.ghost";

        price = 20000;

        lore = new String[]{
                "&6&lCOSAS",
                "",
                "&7- &fEspada de madera",
                "&7- &fPociones curativas arrojadizas",
                "&7- &f*Fantasma*"
        };

        displayItem = new CItemStack(Material.GLASS_BOTTLE).setName("&bESPIRITU").build();

        boots = new CLeatherArmor(Material.LEATHER_BOOTS).color(Color.BLACK).makeUnbreakable().build();

        hotbar[0] = new CItemStack(Material.WOOD_SWORD).makeUnbreakable().build();
        hotbar[1] = new CPotion().addInstantEffect(true, 1).splash().setAmt(2).build();

        addEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
	}

	@Override
	public void onSneak(PlayerToggleSneakEvent event, Player player) {
		if(event.isSneaking()) player.getInventory().setBoots(null);
		else player.getInventory().setBoots(boots.clone());
	}

}
