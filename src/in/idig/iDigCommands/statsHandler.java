package in.idig.iDigCommands;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

public class statsHandler implements CommandExecutor{
	
	
	public statsHandler(iDigCommands iDigCommands) {
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		//private Logger log = Logger.getLogger("Minecraft");
		try {			
			//TODO: Add permission check for permission to use command
			//sender.sendMessage("test stats");
			long max = (Runtime.getRuntime().maxMemory() / 1024 / 1024);
			long total = (Runtime.getRuntime().totalMemory() / 1024 / 1024);
			long free = (Runtime.getRuntime().freeMemory() / 1024 / 1024);
			sender.sendMessage(ChatColor.RED + "STATS");
			sender.sendMessage(ChatColor.RED + "Maximum Ram: " + ChatColor.BLUE + max);
			sender.sendMessage(ChatColor.RED + "Used: " + ChatColor.BLUE + (total - free));
			sender.sendMessage(ChatColor.RED + "Free: " + ChatColor.BLUE + (max - (total - free)));
		} catch (final Exception ex) {
			sender.sendMessage(ChatColor.RED + "Error, check log");
			//TODO: Level.WARNING throws issue I dont know why
			//getLogger().log(Level.WARNING, "[LogBlock] Exception in commands handler: ", ex);
		}
		return false;
	
	}
}
