package io.vevox.icrc;

import static io.vevox.icrc.ICRCPlugin.*;

/**
 * @author Matthew Struble
 */
public class RequestController {

    public static String makeURL(String id){
        return getProtocol() + "://" + getHost() + ":" + getPort() + getPath()
                + (id != null ? "/" + id : "");
    }

    public static int makeRequest(Request req, String id, RequestCallback callback){
        String url = makeURL(id);

        // TODO
        return 0;
    }

}
