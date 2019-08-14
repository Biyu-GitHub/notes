package com.web.cookie;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 记住用户登录信息
 */
@RestController
@RequestMapping("/cookieDemo2")
public class CookieDemo2 {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        // 设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = request.getCookies();
        boolean flag = false;

        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    String last_time = cookie.getValue();
                    flag = true;
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String str_date = dateFormat.format(date);

                    str_date = URLEncoder.encode(str_date);
                    cookie.setValue(str_date);
                    cookie.setMaxAge(60 * 60 * 24);
                    response.addCookie(cookie);


                    last_time = URLDecoder.decode(last_time, "utf-8");

                    return "上次访问的时间为：" + last_time;
                }
            }
        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str_date = sdf.format(date);
        //URL编码
        str_date = URLEncoder.encode(str_date, "utf-8");

        Cookie cookie = new Cookie("lastTime", str_date);
        //设置cookie的存活时间
        cookie.setMaxAge(60 * 60 * 24);//一个月
        response.addCookie(cookie);

        return "您好，欢迎您首次访问";

    }
}
