package com.minecraftdimensions.autoannouncer;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class ServerAnnouncements implements Runnable  {

	ArrayList<String> list = new ArrayList<String>();
	int count = 0;

	public void addAnnouncement(String message) {
		list.add(colorize(message));
	}

	public void run() {
		if (list.isEmpty()) {
			return;
		}
		Player[] players = Bukkit.getOnlinePlayers();
		if (players.length==0) {
			return;
		}
		
		for(Player player: players){
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
