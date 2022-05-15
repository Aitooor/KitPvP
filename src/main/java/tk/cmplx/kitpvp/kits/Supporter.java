package tk.cmplx.kitpvp.kits;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import tk.cmplx.kitpvp.utils.CItemStack;
import tk.cmplx.kitpvp.utils.CLeatherArmor;
import tk.cmplx.kitpvp.utils.CPotion;
import tk.cmplx.kitpvp.utils.Kit;

public class Supporter extends Kit {
	public Supporter() {
        permission = "kitpvp.supporter";
        price = 2250;

        maxHealth = 30;

        lore = new String[]{
                "&6&lCOSAS",
                "",
                "&7- &fPechera de oro Protección 3",
                "&7- &fEspada de Madera Retroceso 1",
                "&7- &f5x Curación instantanea arrojadiz 2",
                "&7- &f3 pociones de resistencia arrojadizas",
                "&7- &f2 pociones de escudo arrojadizas",
                "&7- &f2x Regeneración arrojadiza 2",
                "&7- &f3x Regeneración arrojadiza",
                "&7- &fBrebaje de pociones de la madre bruja",
                "&7- &f4 corazones extra permanentes",
                "&7- &fDebilidad permanente 2"
        };

        displayItem = new CLeatherArmor(Material.LEATHER_HELMET).color(Color.RED).hideFlag(ItemFlag.HIDE_ATTRIBUTES).setName("&bSOPORTE").build();

        helm = new CLeatherArmor(Material.LEATHER_HELMET).color(Color.RED).makeUnbreakable().build();
        chest = new CItemStack(Material.GOLD_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).makeUnbreakable().build();
        legs = new CLeatherArmor(Material.LEATHER_LEGGINGS).color(Color.WHITE).makeUnbreakable().build();
        boots = new CLeatherArmor(Material.LEATHER_BOOTS).color(Color.RED).makeUnbreakable().build();

        hotbar[0] = new CItemStack(Material.WOOD_SWORD).addEnchantment(Enchantment.KNOCKBACK, 1).makeUnbreakable().build();
        hotbar[1] = new CPotion().addInstantEffect(true, 1).splash().setAmt(5).build();
        hotbar[2] = new CPotion().addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 90).setType(PotionType.NIGHT_VISION).splash().setAmt(3).setName("&1Pocion de resistencia").build();
        hotbar[3] = new CPotion().addPotionEffect(PotionEffectType.ABSORPTION, 2, 90).splash().setType(PotionType.FIRE_RESISTANCE).setAmt(2).setName("&6Pocion de escudo").build();
        hotbar[4] = new CPotion().addPotionEffect(PotionEffectType.REGENERATION, 1, 30).splash().setType(PotionType.REGEN).setAmt(2).build();
        hotbar[5] = new CPotion().addPotionEffect(PotionEffectType.REGENERATION, 0, 60).splash().setType(PotionType.REGEN).setAmt(3).build();
        hotbar[8] = new CPotion()
                .addPotionEffect(PotionEffectType.FIRE_RESISTANCE, 36)
                .addInstantEffect(true, 2)
                .addPotionEffect(PotionEffectType.REGENERATION, 1, 44)
                .addPotionEffect(PotionEffectType.ABSORPTION, 25)
                .addPotionEffect(PotionEffectType.BLINDNESS, 3)
                .addPotionEffect(PotionEffectType.CONFUSION, 2)
                .setType(PotionType.JUMP)
                .setName("&cBrebaje de la madre bruja").build();

        effects.add(new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 2));
	}
}
