package com.minecraftdimensions.autoannouncer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadAnnouncementsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Announcements.reloadAnnouncements();
		sender.sendMessage(ChatColor.DARK_GREEN+"Announcements Reloaded");
		return true;
	}

}
