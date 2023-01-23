package com.tplaymeow.itmoweblab4backend.Utils;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Objects;
import java.util.Optional;

public class HTTPHeaderExtractor {
    private final static String TOKEN_PREFIX = "Bearer";



    public static Optional<String> extractJWT(MultivaluedMap<String, String> headers) {
        String authorizationHeader = headers
                .getFirst(HttpHeaders.AUTHORIZATION);
        return Optional
                .of(authorizationHeader)
                .filter(header -> { return header.startsWith(TOKEN_PREFIX); })
                .map(header -> { return header.substring(TOKEN_PREFIX.length()).trim(); });
    }
}
