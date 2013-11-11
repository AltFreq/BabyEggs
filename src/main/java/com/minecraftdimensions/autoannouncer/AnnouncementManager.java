package com.minecraftdimensions.autoannouncer;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitTask;

public class AnnouncementManager {
    public static ArrayList<BukkitTask> announcementTasks = new ArrayList<>();

    public static void loadAnnouncements() {
        //create defaults
        setDefaults();
        // load global announcements
        if ( Announcements.announcer ) {
            List<String> server = Announcements.announcements.getListString( "Announcements.Server.Messages", new ArrayList<String>() );
            if ( !server.isEmpty() ) {
                int interval = Announcements.announcements.getInt( "Announcements.Server.Interval", 0 );
                if ( interval > 0 ) {
                    ServerAnnouncements g = new ServerAnnouncements();
                    for ( String messages : server ) {
                        g.addAnnouncement( messages );
                    }
                    BukkitTask t = Bukkit.getScheduler().runTaskTimer(AutoAnnouncer.instance, g, interval*20,interval*20);
                    announcementTasks.add( t );
                }
            }
            //load server announcements
            for ( World world : Bukkit.getWorlds() ) {
                List<String> worldmes = Announcements.announcements.getListString( "Announcements." + world.getName() + ".Messages", new ArrayList<String>() );
                if ( !worldmes.isEmpty() ) {
                    int interval = Announcements.announcements.getInt( "Announcements." + world.getName() + ".Interval", 0 );
                    if ( interval > 0 ) {
                        WorldAnnouncements s = new WorldAnnouncements(world);
                        for ( String messages : worldmes ) {
                            s.addAnnouncement( messages );
                        }
                        BukkitTask t = Bukkit.getScheduler().runTaskTimer(AutoAnnouncer.instance, s, interval*20, interval*20);
                        announcementTasks.add( t );
                    }
                }
            }
        }
    }

    private static void setDefaults() {
        List<String> check = Announcements.announcements.getSubNodes( "Announcements" );
        if ( !check.contains( "Server" ) ) {
            Announcements.announcements.setInt( "Announcements.Server.Interval", 300 );
            List<String> l = new ArrayList<String>();
            l.add( "&4Welcome to the server!" );
            l.add( "&aDon't forget to check out our website" );
            Announcements.announcements.setListString( "Announcements.Server.Messages", l );
        }
        for (World world : Bukkit.getWorlds() ) {
            if ( !check.contains( world.getName() ) ) {
                Announcements.announcements.setInt( "Announcements." + world.getName() + ".Interval", 150 );
                List<String> l = new ArrayList<String>();
                l.add( "&4Welcome to the " + world.getName() + " server!" );
                l.add( "&aDon't forget to check out our website" );
                Announcements.announcements.setListString( "Announcements." + world.getName() + ".Messages", l );
            }
        }
    }

    public static void reloadAnnouncements() {
        for ( BukkitTask task : announcementTasks ) {
            task.cancel();
        }
        announcementTasks.clear();
        loadAnnouncements();
    }
}
