package me.hammale.suicide;

import java.util.TimerTask;
/**
* Cool class. That it is :D
*
* @author nickguletskii200
*/
public class BukkitTimer {
	private int id;
	private suicide plugin;
	
	public BukkitTimer(suicide plug) {
		plugin = plug;
	}	
	public void scheduleAtFixedRate(TimerTask tsk, int delay) {
		id = plugin.getServer().getScheduler().scheduleSyncDelayedTask(
		plugin, tsk, delay);
	}
	
	public void cancel() {
			plugin.getServer().getScheduler().cancelTask(id);
	}
}

