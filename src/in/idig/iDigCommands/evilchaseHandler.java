package in.idig.iDigCommands;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class evilchaseHandler implements CommandExecutor{
	
	private Logger logger = Logger.getLogger("Minecraft");
	
	public evilchaseHandler(iDigCommands iDigCommands) {
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
		try {			
			//TODO: Add permission check for permission to use command
			if (args.length == 0) {
				sender.sendMessage(ChatColor.DARK_AQUA + "You sentenced no one.");
				sender.sendMessage(ChatColor.DARK_AQUA + "For help use: /evilchase help ");
			} else {
				final String command = args[0].toLowerCase();
				if (command.equals("help")) {
					sender.sendMessage(ChatColor.DARK_AQUA + "evilchase Help:");
					//TODO: Add Smack Help
					sender.sendMessage(ChatColor.GOLD + "Nothing here");
					
				} else{
					try {
						
						Player other = (Bukkit.getServer().getPlayer(args[0]));
						if (other == null) {
							sender.sendMessage(ChatColor.RED + args[0] + " is not online!");
						} else {
							sender.sendMessage(ChatColor.RED + args[0] + " has been smacked!");
							//other.chat("You have been smacked");
							sender.sendMessage("You have smacked " +args[0] +".");
							other.sendMessage(sender.getName() +" has smacked you.");
							//other.sendMessage("test");
							//this.getLogger().log(Level.INFO,sender.getName() + "/smack " + args[0]);
							other.damage(2);
							//TODO: Add smack event
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
