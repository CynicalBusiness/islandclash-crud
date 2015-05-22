package io.vevox.icrc;

import com.google.gson.JsonElement;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * A callback for after requests are sent.
 * @author Matthew Struble
 */
public abstract class RequestCallback extends BukkitRunnable {

    /**
     * Called when a request responds with data. Note that this callback is delayed from the timing
     * of the request. The parent method will return first.
     * @param response The JSON containing the response data.
     */
    public abstract void onReturn(JsonElement response);

}
