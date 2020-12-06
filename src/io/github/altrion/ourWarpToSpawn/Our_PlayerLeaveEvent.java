package io.github.altrion.ourWarpToSpawn;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * 
 * @author GitHub: https://github.com/Altrion ; Spigot: NoPremMC
 * 		Spigot: ourWarpToSpawn
 * 		Originally created for server since when players join they first get teleported to their old location then to spawn!
 */
public class Our_PlayerLeaveEvent implements Listener {
	private Location loc;
	public Our_PlayerLeaveEvent(Location _loc) {
		loc = _loc;
	}
	@EventHandler
	public void onLeave(PlayerQuitEvent pqe) {
		pqe.getPlayer().teleport(loc);
	}

}
