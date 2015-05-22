package io.vevox.icrc;

/**
 * The type of CRUD request being made.
 * @author Matthew Struble
 */
public enum RequestType {
    /**
     * A create(POST) request to create a new object.
     */
    CREATE,
    /**
     * A read (GET) request to read an object by its ID.
     */
    READ,
    /**
     * An update (PUT) request to modify an existing object by its ID.
     */
    UPDATE,
    /**
     * A delete (DELETE) request to delete an existing object by its ID.
     */
    DELETE;

    /**
     * Returns whether or not this request type will require data. CREATE and UPDATE request will
     * require data.
     * @return True if data is required, false otherwise.
     */
    public boolean data(){
        return this == CREATE || this == UPDATE;
    }

    /**
     * Returns whether or not this request requires an ID. All requests except READ require an ID,
     * but an ID can be used during READ to filter results.
     * @return True if an ID is required, false otherwise.
     */
    public boolean requireID(){
        return this != READ;
    }

    /**
     * Gets the http method of this request type.
     * @return The HTTP method.
     */
    public String getHttpMethod(){
        switch (this){
            case CREATE: return "POST";
            case READ: return "GET";
            case UPDATE: return "PUT";
            case DELETE: return "DELETE";
        }
        return "GET";
    }

}
