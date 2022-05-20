package net.eternaln.kitpvp.event;

import java.util.Random;

import net.eternaln.kitpvp.utils.Log;
import net.eternaln.kitpvp.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.eternaln.kitpvp.Main;

public class Death implements Listener {

	public Death() {
		Log.info("Registered PlayerDeath Event!");
	}

	@EventHandler
	public void onKill(PlayerDeathEvent e) {
		e.setDroppedExp(0);
		e.getDrops().clear();

		Player death = e.getEntity();

		e.setDeathMessage(Utils.tr("&b" + death.getDisplayName() + " &cmurio."));

		death.setMaxHealth(20);
		death.setLevel(0);

		Bukkit.getScheduler().runTaskLater(Main.instance, () -> death.spigot().respawn(), 20L);

		if (e.getEntity().getKiller() == null)
			return;

		Player killer = e.getEntity().getKiller().getPlayer();

		if (killer.getName() == death.getName()) {
			e.setDeathMessage(Utils.tr("&b" + death.getDisplayName() + " &cno queria vivir mas"));
			return;
		}

		killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 50, 4));
		killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 3, 2);
		killer.setLevel(killer.getLevel() + 1);

		e.setDeathMessage(Utils.tr("&c" + death.getDisplayName() + "&f fue asesinado por &b" + killer.getDisplayName()));

		if (Main.economyHook) {
			Random r = new Random();
			int base = 4 + r.nextInt(6);
			int boost = 0;
			int killstreakBonus = 0;

			switch (killer.getLevel()) {
				case 3: {
					Utils.bcast("&c" + killer.getDisplayName() + " &ftiene una racha de &b3 &fasesinatos");
					killstreakBonus = 10;
					Utils.msg(killer, "&aObtienes una bonificación de racha de asesinatos de &e" + killstreakBonus + "&6⛃");
					break;
				}
				case 5: {
					Utils.bcast("&c" + killer.getDisplayName() + " &ftiene una racha de &b5 &fasesinatos");
					killstreakBonus = 30;
					Utils.msg(killer, "&aRecibes una bonificación de racha de asesinatos de &e" + killstreakBonus + "&6⛃");
					break;
				}
				case 10: {
					Utils.bcast("&c" + killer.getDisplayName() + " &ftiene una racha de &b10 &fasesinatos");
					killstreakBonus = 50;
					Utils.msg(killer, "&aObtienes una bonificación de racha de asesinatos de &e" + killstreakBonus + "&6⛃");
					break;
				}
				case 50: {
					Utils.bcast("&c" + killer.getDisplayName() + " &ftiene una racha de &b50 &fasesinatos");
					killstreakBonus = 2000;
					Utils.msg(killer, "&aRecibes una bonificación de racha de asesinatos de &e" + killstreakBonus + "&6⛃");
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
				Utils.msg(killer, "&fHas ganado &e" + base + "&6⛃ &fcon &e" + killstreakBonus + " &fbajas de racha de muertes");
			} else {
				Main.instance.econ.depositPlayer(killer, base + boost + killstreakBonus);
				Utils.msg(killer, "&fHas ganado &e" + (base + boost) + "&6⛃ &fcon un boost de &8(&b" + boostType + "&8)");
			}

		}
	}

}
