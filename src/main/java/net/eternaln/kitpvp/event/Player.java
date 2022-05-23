package net.eternaln.kitpvp.event;

import me.clip.placeholderapi.PlaceholderAPI;
import net.eternaln.kitpvp.Main;
import net.eternaln.kitpvp.utils.CenteredMessage;
import net.eternaln.kitpvp.utils.LocationUtil;
import net.eternaln.kitpvp.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;


public class Player implements Listener {

    private final FileConfiguration config;

    public Player(Main plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        org.bukkit.entity.Player player = event.getPlayer();
        
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().clear();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.getActivePotionEffects().clear();
        
        tpSpawn(player);

        event.setJoinMessage(null);

        String name = "&f%player_name% ";
        name = PlaceholderAPI.setPlaceholders(event.getPlayer(), name);
        String rank = "%vault_prefix% ";
        rank = PlaceholderAPI.setPlaceholders(event.getPlayer(), rank);

        CenteredMessage.Chat.sendCenteredMessage(player, "");
        CenteredMessage.Chat.sendCenteredMessage(player, config.getString("ONJOIN.TITLE"));
        CenteredMessage.Chat.sendCenteredMessage(player, "");
        CenteredMessage.Chat.sendCenteredMessage(player, "&a&lIP &7&oeternaln.net");
        CenteredMessage.Chat.sendCenteredMessage(player, "&a&lTIENDA &7&ohttps://tienda.eternaln.net");
        CenteredMessage.Chat.sendCenteredMessage(player, "&a&lDISCORD &7&ohttps://discord.com/invite/bMarGsQYfb");
        CenteredMessage.Chat.sendCenteredMessage(player, "");
        CenteredMessage.Chat.sendCenteredMessage(player, rank + name + Utils.ct("&cMata el maximo posible"));
        CenteredMessage.Chat.sendCenteredMessage(player, Utils.ct("&b¡Consigue entrar en los TOPs!"));

        boolean hideHiddenPlayers = true;

        // TODO: Use per-player files.
        if (config.getStringList("VANISH-ON-JOIN").contains(player.getUniqueId().toString())) {
            hideHiddenPlayers = false;
            Bukkit.dispatchCommand(
                    player,
                    "vanish"
            );
        }

        for (org.bukkit.entity.Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.hasMetadata("kitpvp.vanish") && hideHiddenPlayers) {
                player.hidePlayer(onlinePlayer);
            }
        }
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }
    
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        org.bukkit.entity.Player player = event.getPlayer();
        
        if(player.getLocation().getBlockY() < 0) {
            tpSpawn(player);
        }
    }
    
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onWeather(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
    
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        if(event.getPlayer() != null) {
            tpSpawn(event.getPlayer());
        }
    }
    
    private void tpSpawn(org.bukkit.entity.Player player) {
        if(config.getString("LOCATION.SPAWN") == null) {
            return;
        }

        player.teleport(LocationUtil.parseToLocation(config.getString("LOCATION.SPAWN")));
    }

}
