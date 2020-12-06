package io.github.altrion.ourWarpToSpawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
/**
 * 
 * @author GitHub: https://github.com/Altrion ; Spigot: NoPremMC
 * 		Spigot: ourWarpToSpawn
 * 		Originally created for server since when players join they first get teleported to their old location then to spawn!
 */
public class OurWTS extends JavaPlugin{

	public void onEnable() {
		saveDefaultConfig();
		reloadConfig();
		Location loc = null;
		try {
			double x,y,z,
			rotX,rotY;
			World w = Bukkit.getWorld(this.getConfig().getString("Location.world"));
			if(w == null) w = Bukkit.getWorlds().get(0);
			x=this.getConfig().getDouble("Location.x");
			y=this.getConfig().getDouble("Location.y");
			z=this.getConfig().getDouble("Location.z");
			rotX=this.getConfig().getDouble("Location.rotation.yaw");
			rotY=this.getConfig().getDouble("Location.rotation.pitch");

			loc=new Location(w, x, y, z,(float) rotX,(float) rotY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(loc == null) {
			Bukkit.getConsoleSender().sendMessage(
					"OurWarpToSpawn " 
					+ChatColor.BLUE 
					+">> " 
					+ChatColor.DARK_RED 
					+"ERROR:"
					+ChatColor.RED 
					+" Invalid Location!");
			return;
		}
		Bukkit.getPluginManager().registerEvents(new Our_PlayerLeaveEvent(loc), this);
	}
}
