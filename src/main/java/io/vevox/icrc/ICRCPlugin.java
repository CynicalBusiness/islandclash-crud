package io.vevox.icrc;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Matthew Struble
 */
public class ICRCPlugin extends JavaPlugin {

    private static ICRCPlugin instance;
    private static String protocol,host,path;
    private static int port;

    @Override
    public void onEnable(){
        instance = this;
        saveDefaultConfig();
        protocol = getConfig().getString("server.protocol");
        host = getConfig().getString("server.host");
        path = getConfig().getString("server.path");
        port = getConfig().getInt("server.port");
    }

    @Override
    public void onDisable(){
        instance = null;
    }

    public static ICRCPlugin getInstance(){
        return instance;
    }

    public static String getProtocol(){
        return protocol;
    }

    public static String getHost(){
        return host;
    }

    public static String getPath(){
        return path;
    }

    public static int getPort(){
        return port;
    }

}
