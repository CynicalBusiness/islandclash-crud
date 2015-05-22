package io.vevox.icrc;

import com.google.gson.JsonElement;

import java.io.Serializable;

/**
 * A base interface for all CRUD requests.
 * @author Matthew Struble
 */
public interface Request extends Serializable {

    /**
     * Gets the request method type for this request.
     * @return The method type of GET, POST, PUT, or DELETE.
     */
    RequestType getMethod();

    /**
     * The data to be sent to the server in JSON format. If no data is to
     * be sent, return null.
     * @return The JSON data to be sent.
     */
    JsonElement data();

}
