package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.CLeatherArmor;
import net.eternaln.kitpvp.utils.CPotion;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class Berserker extends Kit {
	public Berserker() {
        permission = "kitpvp.berserker";
        price = 3000;

        lore = new String[]{
                "&6&lCOSAS",
                "&r",
                " &7- &fHacha de leñador",
                " &7- &fCamisa a Cuadros Roja",
                " &7- &fPantalones Azules",
                " &7- &fBotas de trabajo negras",
                " &7- &fJarabe de Vida",
        };

        displayItem = new CItemStack(Material.IRON_AXE).setName("&bBERSERKER").build();

        chest = new CLeatherArmor(Material.LEATHER_CHESTPLATE).color(Color.RED).makeUnbreakable().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build();
        legs = new CLeatherArmor(Material.LEATHER_LEGGINGS).color(Color.BLUE).makeUnbreakable().build();
        boots = new CLeatherArmor(Material.LEATHER_BOOTS).color(Color.BLACK).makeUnbreakable().build();

        hotbar[0] = new CItemStack(Material.IRON_AXE).addEnchantment(Enchantment.DAMAGE_ALL, 1).makeUnbreakable().build();
        hotbar[1] = new CPotion().addInstantEffect(true).setName("&cJarabe de Vida").build();
	}
}
