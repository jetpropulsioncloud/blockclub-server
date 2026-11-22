package com.blockclub.gkp;

import java.util.List;
import java.util.Locale;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * BlockClubGKP v1.2.1: restrict political consequences of PvP to explicitly
 * allowed worlds. Does not change whether PvP itself is permitted.
 * Existing cooldowns and relationship scoring remain owned by
 * GroupKgpPlugin.handlePvpKill().
 */
public final class PvpListener implements Listener {
    private final GroupKgpPlugin plugin;

    public PvpListener(GroupKgpPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (!plugin.getConfig().getBoolean("pvp.enabled", true)) return;
        final Player victim = event.getEntity();
        final Player killer = victim.getKiller();
        if (killer == null || victim.equals(killer)) return;

        if (!politicalPvpAllowed(victim.getWorld())
            || !politicalPvpAllowed(killer.getWorld())) return;

        final String killerGuild = plugin.getGuild(killer);
        final String victimGuild = plugin.getGuild(victim);
        if (killerGuild == null || victimGuild == null
                || killerGuild.equalsIgnoreCase(victimGuild)) return;
        if (!plugin.isTrackedGuild(killerGuild)
            || !plugin.isTrackedGuild(victimGuild)) return;

        plugin.handlePvpKill(killer, killerGuild, victim, victimGuild);
    }

    private boolean politicalPvpAllowed(World world) {
        if (world == null) return false;
        if (!plugin.getConfig().getBoolean("pvp.frontier-only", true)) return true;
        List<String> allowed = plugin.getConfig().getStringList("pvp.allowed-worlds");
        if (allowed == null || allowed.isEmpty()) {
            return world.getName().equalsIgnoreCase("guild_frontier");
        }
        String worldName = world.getName().toLowerCase(Locale.ROOT);
        for (String configuredName : allowed) {
            if (configuredName != null
                    && worldName.equals(configuredName.strip().toLowerCase(Locale.ROOT)))
                return true;
        }
        return false;
    }
}
