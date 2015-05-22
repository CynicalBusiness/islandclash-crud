package io.vevox.icrc;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Core IslandClash RESTful CRUD plug-in.
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

    protected static ICRCPlugin getInstance(){
        return instance;
    }

    /**
     * Gets the protocol the REST server is running on, either 'http' or 'https'.
     * @return The protocol.
     */
    public static String getProtocol(){
        return protocol;
    }

    /**
     * Gets the host the REST server is running on.
     * @return The host.
     */
    public static String getHost(){
        return host;
    }

    /**
     * Gets the server base path this plug-in is to use for making REST requests.
     * @return The base path.
     */
    public static String getPath(){
        return path;
    }

    /**
     * Gets the port the REST server is running on.
     * @return The port.
     */
    public static int getPort(){
        return port;
    }

}
