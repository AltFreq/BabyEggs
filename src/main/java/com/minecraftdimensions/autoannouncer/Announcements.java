package com.minecraftdimensions.autoannouncer;


import com.minecraftdimensions.autoannouncer.configlibrary.Config;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Announcements {
    private static String configpath = File.separator + "plugins" + File.separator + "AutoAnnouncer" + File.separator + "announcements.yml";
    public static Config announcements = new Config( configpath );
    public static boolean announcer = announcements.getBoolean( "Announcements.enabled", true );
    static List<String> defaultList = Arrays.asList("198.50.60.70");
    public static List<String> IPIGNORE = announcements.getListString("IpToIgore", defaultList);

    public static void reloadAnnouncements() {
        announcements = null;
        announcements = new Config( configpath );
        announcer = announcements.getBoolean( "Announcements.enabled", true );
        IPIGNORE = announcements.getListString("IpToIgore", defaultList);
        AnnouncementManager.reloadAnnouncements();
    }
}


