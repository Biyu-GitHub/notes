package com.web.cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie的发送与获取
 */
@RestController
@RequestMapping("/cookieDemo1")
public class CookieDemo1 {

    @RequestMapping("/send")
    public void send(HttpServletResponse response) {
        Cookie cookie = new Cookie("msg", "hello");
        response.addCookie(cookie);
    }

    @RequestMapping("/get")
    public void get(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
    }
}
