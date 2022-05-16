package net.eternaln.kitpvp.kits;

import net.eternaln.kitpvp.utils.CItemStack;
import net.eternaln.kitpvp.utils.CLeatherArmor;
import net.eternaln.kitpvp.utils.CPotion;
import net.eternaln.kitpvp.utils.Kit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class Dressmaker extends Kit {
	public Dressmaker() {
        permission = "kitpvp.dressmaker";
        price = 2150;

        lore = new String[]{
                "&6&lCOSAS",
                "",
                " &7- &fZapatos Versace",
                " &7- &fCamiseta Gucci",
                "&7- &fArma de defensa personal",
                "&7- &f2 jugos de frambuesa",
                "&7- &fManzana acaramelada"
        };

        displayItem = new CItemStack(Material.CAKE).setName("&bMODISTA").build();

        boots = new CItemStack(Material.DIAMOND_BOOTS)
                .setName("&eZapatos Versace")
                .addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7)
                .addEnchantment(Enchantment.THORNS, 2)
                .makeUnbreakable()
                .build();

        chest = new CLeatherArmor(Material.LEATHER_CHESTPLATE).color(Color.FUCHSIA).makeUnbreakable().setName("&cCamiseta Gucci").build();

        hotbar[0] = new CItemStack(Material.WOOD_SPADE)
                .makeUnbreakable()
                .setName("&fArma de defensa personal")
                .addEnchantment(Enchantment.DAMAGE_ALL, 4)
                .addEnchantment(Enchantment.KNOCKBACK, 4)
                .build();

        hotbar[1] = new CPotion().addInstantEffect(true, 1).setName("&dJugo de frambuesa").build();
        hotbar[2] = new CItemStack(Material.GOLDEN_APPLE).makeUnbreakable().setName("&6Manzana de caramelo").build();
	}
}
