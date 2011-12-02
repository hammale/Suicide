package me.hammale.suicide;

import java.util.HashSet;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class suicide extends JavaPlugin {
	static Server server;
	static Plugin plugin;
	
	//private final SewerBlockListener blockListener = new SewerBlockListener();
	//public final SewerPlayerListener playerListener = new SewerPlayerListener();
	
	private playerListener playerListener;
	public HashSet<String> active = new HashSet<String>();
	
	@Override
	public void onEnable()
    {	 
	    System.out.println("Suicide Enabled!" );
	    playerListener = new playerListener(this);
		registerEvents();
		
		server = this.getServer();
		plugin = this;
    }
	public void onDisable()
    {
		System.out.println("Suicide Disabled!");
    }
	//active.remove((player).getName());
	private void registerEvents()
    {
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_MOVE, playerListener, Event.Priority.Normal, this);
    }
	
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
		  if (cmd.getName().equalsIgnoreCase("boom")) {
			  if ((sender instanceof Player)) {	
				  Player p = (Player) sender;
				  active.add((p).getName());
				  return true;
			  }
		  }
		  return false;
	  }
	
}