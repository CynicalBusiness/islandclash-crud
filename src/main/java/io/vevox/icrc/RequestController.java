package io.vevox.icrc;

import com.google.gson.JsonParser;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static io.vevox.icrc.ICRCPlugin.*;

/**
 * A basic controller for sending and receiving requests.
 * @author Matthew Struble
 */
@SuppressWarnings("unused") // They're API methods! Rawr.
public class RequestController {

    /**
     * Constructs a string containing url data to server specified in this plug-in's
     * configuration, optionally using an ID.
     * @param route The route name.
     * @param id The ID to use, or <code>null</code> for no ID.
     * @return The string url.
     */
    public static String makeURL(String route, String id){
        return getProtocol() + "://" + getHost() + ":" + getPort() + getPath()
                + "/" + route + (id != null ? "/" + id : "");
    }

    /**
     * Makes a request to the RESTful server backend for database and web communication.
     * @param req The request to make.
     * @param id The ID of the request, or <code>null</code> for no ID.
     * @param callback The callback for the request with response data, or <code>null</code> for no callback.
     * @return The HTTP response code, as defined in the HTTP/1.1 standard.
     * @throws IOException General exceptions when composing the data packets.
     * @throws NullPointerException If the request is <code>null</code>.
     */
    public static int makeRequest(Request req, String id, final RequestCallback callback) throws IOException {
        if (id == null && req.getRequestMethod().requireID())
            throw new IOException("ID is required for " + req.getRequestMethod() + "!");
        URL url = new URL(makeURL(id, req.getRoute()));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(req.getRequestMethod().getHttpMethod());
        if (req.getRequestMethod().data()) {
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(req.getRequestData().toString());
            out.close();
        }
        int code = connection.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        final StringBuilder contentBuilder = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null)
            contentBuilder.append(line);

        new BukkitRunnable(){
            public void run() {
                if (callback != null)
                    callback.onReturn(new JsonParser().parse(new StringReader(contentBuilder.toString())));
            }
        }.runTaskLater(getInstance(), 0L);
        return code;
    }

}
