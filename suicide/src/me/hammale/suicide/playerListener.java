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
	  int i = 1;
	@Override
	public void onPlayerMove(final PlayerMoveEvent e) {
		Block down = e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN, 1);
		if(plugin.active.contains(e.getPlayer().getName()) && down.getType() != Material.AIR){
			Block b = e.getPlayer().getLocation().getBlock();
			b.setType(Material.FIRE);
		}
		}
}