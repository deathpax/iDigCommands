package in.idig.iDigCommands;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class rulerHandler implements CommandExecutor{
	
	private Logger logger = Logger.getLogger("Minecraft");
	
	public rulerHandler(iDigCommands iDigCommands) {
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		try {			
			//TODO: Add permission check for permission to use command
			Player player = (Player) sender;
			Location myLocation = player.getLocation();
			Location spawnLocation=player.getWorld().getSpawnLocation();
			int seaLevel=(int) myLocation.getWorld().getSeaLevel();
			myLocation.setY(seaLevel);
			spawnLocation.setY(seaLevel); 
			if (args.length == 0) {
				
				int distance = (int) myLocation.distance(spawnLocation);
				player.sendMessage("You are "+distance +" blocks from spawn.");
			} else {
				final String command = args[0].toLowerCase();
				if (command.equals("help")) {
					sender.sendMessage(ChatColor.DARK_AQUA + "Ruler Help:");
					//TODO: Add Ruler Help
					sender.sendMessage(ChatColor.GOLD + "Nothing here");
					
				} else{
					try {
						
						Player other = (Bukkit.getServer().getPlayer(args[0]));
						if (other == null) {
							sender.sendMessage(ChatColor.RED + args[0] + " is not online!");
						} else {							
							Location thierLocation = other.getLocation();
							thierLocation.setY(seaLevel);
							int distance = (int) thierLocation.distance(myLocation);
							player.sendMessage("You are "+distance +" blocks from " + args[0]);
							
						}
					} catch (final Exception ex) {
						//I dont know if this will ever be called
						sender.sendMessage(ChatColor.RED + "Error, check log");
					}
				}
				return true;
			}
		} catch (final Exception ex) {
			sender.sendMessage(ChatColor.RED + "Error, check log");
			logger.log(Level.WARNING, "[LogBlock] Exception in commands handler: ", ex);
		}
		
		return false;
		
	}
	
}
