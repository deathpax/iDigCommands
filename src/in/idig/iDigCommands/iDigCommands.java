package in.idig.iDigCommands;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;


public class iDigCommands extends JavaPlugin{
	
	private Logger log = Logger.getLogger("Minecraft");
	private CommandsHandler commandsHandler;

	public CommandsHandler getCommandsHandler() {
		return commandsHandler;
	}
	
	public void onEnable(){
		commandsHandler = new CommandsHandler(this);
		getCommand("idig").setExecutor(commandsHandler);
		
		String PluginVersion = version();
		this.logMessage("***************************");
		this.logMessage("*   iDig Suite Enabled    *");
		this.logMessage("*   " + PluginVersion +"    *");
		this.logMessage("***************************");
		
	}

	public void onDisable(){
		this.logMessage("***************************");
		this.logMessage("*   iDig Suite Disabled    *");
		this.logMessage("***************************");
	}

	public void logMessage(String msg){
		PluginDescriptionFile pdFile = this.getDescription();
		this.log.info(pdFile.getName() + " " + pdFile.getVersion() + ": " + msg);
	}

	public String version(){
		PluginDescriptionFile pdFile = this.getDescription();
		return pdFile.getVersion();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (true)
			sender.sendMessage(ChatColor.RED + "iDig CommandSender Linked in");
		return true;
	}

}
