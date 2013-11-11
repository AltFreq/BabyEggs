package com.minecraftdimensions.autoannouncer;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;


public class WorldAnnouncements implements Runnable {

	ArrayList<String> list = new ArrayList<String>();
	int count = 0;
	World world;

	public WorldAnnouncements(World world) {
		this.world = world;
	}

	public void addAnnouncement(String message) {
		list.add(colorize(message));
	}

	public void run() {
		if (list.isEmpty()) {
			return;
		}
		if (world.getPlayers().isEmpty()) {
			return;
		}
		for(Player player: world.getPlayers()){
			if(Announcements.IPIGNORE.contains(player.getAddress().getAddress().getHostAddress())){
				return;
			}
            for ( String line : list.get(count).split( "\n" ) ) {
            	player.sendMessage(line);
            }
		}
		count++;
		if((count+1)>list.size()){
			count=0;
		}
	}
	public String colorize(String input) {
		return ChatColor.translateAlternateColorCodes('&', input);
	}
}
