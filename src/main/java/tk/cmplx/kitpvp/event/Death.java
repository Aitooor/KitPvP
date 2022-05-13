package tk.cmplx.kitpvp.event;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tk.cmplx.kitpvp.Main;
import tk.cmplx.kitpvp.utils.Log;
import tk.cmplx.kitpvp.utils.Utils;

public class Death implements Listener {

	public Death() {
		Log.info("Registered PlayerDeath Event!");
	}

	@EventHandler
	public void onKill(PlayerDeathEvent e) {
		e.setDroppedExp(0);
		e.getDrops().clear();

		Player death = e.getEntity();

		e.setDeathMessage(Utils.tr("&4" + death.getDisplayName() + "&c murio."));

		death.setMaxHealth(20);
		death.setLevel(0);

		Bukkit.getScheduler().runTaskLater(Main.instance, () -> death.spigot().respawn(), 20L);

		if (e.getEntity().getKiller() == null)
			return;

		Player killer = e.getEntity().getKiller().getPlayer();

		if (killer.getName() == death.getName()) {
			e.setDeathMessage(Utils.tr("&4" + death.getDisplayName() + "&c no queria vivir mas"));
			return;
		}

		killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 50, 4));
		killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3, 2);
		killer.setLevel(killer.getLevel() + 1);

		e.setDeathMessage(Utils.tr("&4" + death.getDisplayName() + "&c fue asesinado por &a" + killer.getDisplayName()));

		if (Main.economyHook) {
			Random r = new Random();
			int base = 4 + r.nextInt(6);
			int boost = 0;
			int killstreakBonus = 0;

			switch (killer.getLevel()) {
				case 3: {
					Utils.bcast("&a" + killer.getDisplayName() + " &6tiene una racha de muertes de &d3!");
					killstreakBonus = 10;
					Utils.msg(killer, "&aObtienes una bonificación de racha de muertes de: " + killstreakBonus + "©!");
					break;
				}
				case 5: {
					Utils.bcast("&a" + killer.getDisplayName() + " &6tiene una racha de muertes de &55!");
					killstreakBonus = 30;
					Utils.msg(killer, "&aRecibes una bonificación de racha de muertes de: " + killstreakBonus + "©!");
					break;
				}
				case 10: {
					Utils.bcast("&a" + killer.getDisplayName() + " &6tiene una racha de muertes de &410!");
					killstreakBonus = 50;
					Utils.msg(killer, "&aObtienes una bonificación de racha de muertes de: " + killstreakBonus + "©!");
					break;
				}
				case 50: {
					Utils.bcast("&a" + killer.getDisplayName() + " &6tiene una racha de muertes de &050!");
					killstreakBonus = 2000;
					Utils.msg(killer, "&aRecibes una bonificación de racha de muertes de: " + killstreakBonus + "©!");
					break;
				}
				default:
					break;
			}

			String boostType = "";

			if (killer.hasPermission("kitpvp.coinboost.4x")) {
				boost = 15 + r.nextInt(15);
				boostType = "4x";
			} else if (killer.hasPermission("kitpvp.coinboost.2x")) {
				boost = 5 + r.nextInt(5);
				boostType = "2x";
			}

			if (boost == 0) {
				Main.instance.econ.depositPlayer(killer, base + killstreakBonus);
				Utils.msg(killer, "&aTú tienes: &6" + base + "© &a¡Obtener!");
			} else {
				Main.instance.econ.depositPlayer(killer, base + boost + killstreakBonus);
				Utils.msg(killer, "&aTú tienes: &6+" + (base + boost) + "© &a¡Obtener! &d(" + boostType + " el Booster activo!)");
			}

		}
	}

}
