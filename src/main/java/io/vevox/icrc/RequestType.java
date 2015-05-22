package io.vevox.icrc;

/**
 * @author Matthew Struble
 */
public enum RequestType {

    CREATE,

    READ,

    UPDATE,

    DELETE;

    public boolean data(){
        return this == CREATE || this == UPDATE;
    }

    public boolean requireID(){
        return this != READ;
    }

    public String method(){
        switch (this){
            case CREATE: return "POST";
            case READ: return "GET";
            case UPDATE: return "PUT";
            case DELETE: return "DELETE";
        }
        return "GET";
    }

}
