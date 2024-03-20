package com.colak.springfeignclienttutorial.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;

public class HttpServletRequestUtil {

    public static HttpHeaders getHeaders(HttpServletRequest httpServletRequest) {
        var iterator = httpServletRequest.getHeaderNames().asIterator();
        HttpHeaders headers = new HttpHeaders();
        while (iterator.hasNext()) {
            var key = iterator.next();
            headers.add(key, httpServletRequest.getHeader(key));
        }
        return headers;
    }
}
