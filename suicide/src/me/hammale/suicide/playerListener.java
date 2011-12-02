package me.hammale.suicide;

import java.util.TimerTask;
import me.hammale.suicide.BukkitTimer;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;

public class playerListener extends PlayerListener {

	  public suicide plugin;
	
	  public playerListener(suicide plugin)
	  {
	    this.plugin = plugin;
	  }
	
	public void onPlayerMove(final PlayerMoveEvent e) {
		if(plugin.active.contains(e.getPlayer().getName())){
			Player p = e.getPlayer();
			final World w = p.getWorld();
  			 final BukkitTimer plt = new BukkitTimer(plugin);
			  TimerTask tsk = new TimerTask() {
			  @Override
			  public void run() {
				  int i = 1;
				  Block b = e.getPlayer().getLocation().getBlock();
				  Block fire = b.getRelative(BlockFace.UP, 1);
				  fire.setType(Material.FIRE);
				  e.getPlayer().sendMessage(Integer.toString(i));
				  //plt.cancel();
				  i++;
			  }
			  };
			  plt.scheduleAtFixedRate(tsk, 60); 
	   		w.createExplosion(e.getPlayer().getLocation(), 5);
	   		plugin.active.remove(e.getPlayer().getName());
		}
	}
}	