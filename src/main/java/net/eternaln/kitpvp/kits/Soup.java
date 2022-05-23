package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Soup extends Kit {
	public Soup() {
        permission = "kitpvp.soup";
        price = 3500;

       	lore = new String[]{
                "&6&lCOSAS",
                "",
                " &7- &fEspada de piedra",
                " &7- &fArmadura de cota de malla completa",
                " &7- &f8 sopas mágicas",
                " &7- &fCuración al usar las sopas"
        };

        displayItem = new CItemStack(Material.MUSHROOM_SOUP).setName("&bSOPITA").build();

        helm = new CItemStack(Material.CHAINMAIL_HELMET).makeUnbreakable().build();
        chest = new CItemStack(Material.CHAINMAIL_CHESTPLATE).makeUnbreakable().build();
        legs = new CItemStack(Material.CHAINMAIL_LEGGINGS).makeUnbreakable().build();
        boots = new CItemStack(Material.CHAINMAIL_BOOTS).makeUnbreakable().build();

        hotbar[0] = new CItemStack(Material.STONE_SWORD).makeUnbreakable().build();
        multiStack(new CItemStack(Material.MUSHROOM_SOUP).setName("&eSopa mágica").build(), 8);
	}

	@Override
	public void onItemUse(PlayerInteractEvent e, Player p, ItemStack item) {
		if (item.getType().equals(Material.MUSHROOM_SOUP) && p.getHealth() + 5 <= p.getMaxHealth()) {
			p.setHealth(p.getHealth() + 5);
			p.getItemInHand().setType(Material.BOWL);
		}
	}

}
