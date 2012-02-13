package in.idig.iDigCommands;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class iDigCommands extends JavaPlugin{
	
	private Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){
		this.logMessage("***************************");
		this.logMessage("*   iDig Suite Enabled    *");
		this.logMessage("*   " + version() +"    *");
		this.logMessage("***************************");
	}
	
	public void onDisable(){
		this.logMessage("Disabled.");
	}
	
	public void logMessage(String msg){
		PluginDescriptionFile pdFile = this.getDescription();
		this.log.info(pdFile.getName() + " " + pdFile.getVersion() + ": " + msg);
	}
	
	public string version(){
		PluginDescriptionFile pdFile = this.getDescription();
		return pdFile.getVersion();
	}

}
