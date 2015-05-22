package io.vevox.icrc;

import com.avaje.ebean.text.json.JsonElement;

/**
 * @author Matthew Struble
 */
public abstract class RequestCallback {

    public abstract void onReturn(JsonElement response);

}
