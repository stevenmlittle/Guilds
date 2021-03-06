package steven.vitals2;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	
	private Main plugin = Main.getPlugin(Main.class);
	
	//files and configs here
	public FileConfiguration playerData;
	public File players;
	
	public FileConfiguration guildItemsData;
	public File guildItems;
	
	public FileConfiguration guildShopData;
	public File guildShops;
	
	public void setupPlayers() {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		players = new File(plugin.getDataFolder(), "players.yml");
		
		if (!players.exists()) {
			try {
				players.createNewFile();
			}
			catch(IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not create the players.yml file");
			}
		}
		
		playerData = YamlConfiguration.loadConfiguration(players);
	}
	
	public FileConfiguration getPlayers() {
		return playerData;
	}
	
	public void savePlayers() {
		try {
			playerData.save(players);
		}
		catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the players.yml file");
		}
	}
	
	public void reloadPlayers() {
		playerData = YamlConfiguration.loadConfiguration(players);
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "The players.yml file has been reloaded");
	}
	
	public void setupGuilds() {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		guildItems = new File(plugin.getDataFolder(), "guildItems.yml");
		
		if (!guildItems.exists()) {
			try {
				guildItems.createNewFile();
			}
			catch(IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not create the guildItems.yml file");
			}
		}
		
		guildItemsData = YamlConfiguration.loadConfiguration(guildItems);
	}
	
	public FileConfiguration getGuildItems() {
		return guildItemsData;
	}
	
	public void saveGuildItems() {
		try {
			guildItemsData.save(guildItems);
		}
		catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the guildItems.yml file");
		}
	}
	
	public void reloadGuildItems() {
		guildItemsData = YamlConfiguration.loadConfiguration(guildItems);
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "The guildItems.yml file has been reloaded");
	}
	
	public void setupShops() {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		guildShops = new File(plugin.getDataFolder(), "shops.yml");
		
		if (!guildShops.exists()) {
			try {
				guildShops.createNewFile();
			}
			catch(IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not create the shops.yml file");
			}
		}
		
		guildShopData = YamlConfiguration.loadConfiguration(guildShops);
	}
	
	public FileConfiguration getShops() {
		return guildShopData;
	}
	
	public void saveShops() {
		try {
			guildShopData.save(guildShops);
		}
		catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the players.yml file");
		}
	}
	
	public void reloadShops() {
		guildShopData = YamlConfiguration.loadConfiguration(guildShops);
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "The players.yml file has been reloaded");
	}
}
