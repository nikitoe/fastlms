package com.zerobase.fastlms.util;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;

public class RequestUtils {

    public static String getUserAgent(HttpServletRequest request) {
        return request.getHeader("User-Agent").toString();
    }

    public static String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("X-FORWARDED-FOR");

        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("WL-Proxy-Client-IP");  // 웹로직
        }

        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("HTTP_CLIENT_IP");  // 웹로직
        }

        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  // 웹로직
        }

        if (ip == null || ip.length() == 0) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

}
