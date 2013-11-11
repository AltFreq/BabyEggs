package com.minecraftdimensions.autoannouncer;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class AutoAnnouncer extends JavaPlugin {


	public static Plugin instance;
	public static FileConfiguration config;

	@Override
	public void onEnable() {
		instance = this;
		AnnouncementManager.loadAnnouncements();
        getCommand( "announcementreload" ).setExecutor( new ReloadAnnouncementsCommand() );
	}


}
