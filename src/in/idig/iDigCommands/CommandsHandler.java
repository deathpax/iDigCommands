package in.idig.iDigCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandsHandler implements CommandExecutor{

	public CommandsHandler(iDigCommands iDigCommands){
		// TODO Auto-generated constructor stub
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		try {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "iDig by the iDig Dev team");
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "Type /iDig help for help");
			} else {
				final String command = args[0].toLowerCase();
				if (command.equals("help")) {
					sender.sendMessage(ChatColor.DARK_AQUA + "LogBlock Help:");
					sender.sendMessage(ChatColor.GOLD + "For the commands list type '/lb commands'");
					sender.sendMessage(ChatColor.GOLD + "For the parameters list type '/lb params'");
					sender.sendMessage(ChatColor.GOLD + "For the list of permissions you got type '/lb permissions'");
				} else if (command.equals("commands")) {
					sender.sendMessage(ChatColor.DARK_AQUA + "LogBlock Commands:");
					sender.sendMessage(ChatColor.GOLD + "/lb tool -- Gives you the lb tool");
					sender.sendMessage(ChatColor.GOLD + "/lb tool [on|off] -- Enables/Disables tool");
					sender.sendMessage(ChatColor.GOLD + "/lb tool [params] -- Sets the tool lookup query");
					sender.sendMessage(ChatColor.GOLD + "/lb tool default -- Sets the tool lookup query to default");
					sender.sendMessage(ChatColor.GOLD + "/lb toolblock -- Analog to tool");
					sender.sendMessage(ChatColor.GOLD + "/lb hide -- Hides you from log");
					sender.sendMessage(ChatColor.GOLD + "/lb rollback [params] -- Rollback");
					sender.sendMessage(ChatColor.GOLD + "/lb redo [params] -- Redo");
					sender.sendMessage(ChatColor.GOLD + "/lb tp [params] -- Teleports you to the location of griefing");
					sender.sendMessage(ChatColor.GOLD + "/lb writelogfile [params] -- Writes a log file");
					sender.sendMessage(ChatColor.GOLD + "/lb lookup [params] -- Lookup");
					sender.sendMessage(ChatColor.GOLD + "/lb prev|next -- Browse lookup result pages");
					sender.sendMessage(ChatColor.GOLD + "/lb page -- Shows a specific lookup result page");
					sender.sendMessage(ChatColor.GOLD + "/lb me -- Displays your stats");
					sender.sendMessage(ChatColor.GOLD + "Look at github.com/DiddiZ/LogBlock/wiki/Commands for the full commands reference");
				} else if (command.equals("params")) {
					sender.sendMessage(ChatColor.DARK_AQUA + "LogBlock Query Parameters:");
					sender.sendMessage(ChatColor.GOLD + "Use doublequotes to escape a keyword: world \"world\"");
					sender.sendMessage(ChatColor.GOLD + "player [name1] <name2> <name3> -- List of players");
					sender.sendMessage(ChatColor.GOLD + "block [type1] <type2> <type3> -- List of block types");
					sender.sendMessage(ChatColor.GOLD + "created, destroyed -- Show only created/destroyed blocks");
					sender.sendMessage(ChatColor.GOLD + "chestaccess -- Show only chest accesses");
					sender.sendMessage(ChatColor.GOLD + "area <radius> -- Area around you");
					sender.sendMessage(ChatColor.GOLD + "selection, sel -- Inside current WorldEdit selection");
					sender.sendMessage(ChatColor.GOLD + "world [worldname] -- Changes the world");
					sender.sendMessage(ChatColor.GOLD + "time [number] [minutes|hours|days] -- Limits time");
					sender.sendMessage(ChatColor.GOLD + "since <dd.MM.yyyy> <HH:mm:ss> -- Limits time to a fixed point");
					sender.sendMessage(ChatColor.GOLD + "before <dd.MM.yyyy> <HH:mm:ss> -- Affects only blocks before a fixed time");
					sender.sendMessage(ChatColor.GOLD + "limit <row count> -- Limits the result to count of rows");
					sender.sendMessage(ChatColor.GOLD + "sum [none|blocks|players] -- Sums the result");
					sender.sendMessage(ChatColor.GOLD + "asc, desc -- Changes the order of the displayed log");
					sender.sendMessage(ChatColor.GOLD + "coords -- Shows coordinates for each block");
					sender.sendMessage(ChatColor.GOLD + "silent -- Displays lesser messages");
				} else if (command.equals("permissions")) {
					sender.sendMessage(ChatColor.DARK_AQUA + "You've got the following permissions:");
				} else if (command.equals("hide")) {
					
				} else if (command.equals("page")) {
					
				
				} else if (command.equals("me")) {
					if (sender instanceof Player) {
						//TODO: Fix this permission name
						//if (logblock.hasPermission(sender, "logblock.me")) {
							
						
					} else
						sender.sendMessage(ChatColor.RED + "You have to be a player.");
				} else if (command.equals("writelogfile")) {
					
				} else if (command.equals("clearlog")) {
					
				} else if (command.equals("tp")) {
					
				} else
					sender.sendMessage(ChatColor.RED + "Unknown command '" + args[0] + "'");
			}
		} catch (final IllegalArgumentException ex) {
			sender.sendMessage(ChatColor.RED + ex.getMessage());
		} catch (final Exception ex) {
			sender.sendMessage(ChatColor.RED + "Error, check log");
			//TODO: Level.WARNING throws issue I dont know why
			//getLogger().log(Level.WARNING, "[LogBlock] Exception in commands handler: ", ex);
		}
		return true;
	}
}
