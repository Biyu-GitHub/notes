package com.web.session;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sessionDemo1")
public class SessionDemo1 {

    @RequestMapping("set")
    public String set(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("msg", "hello session");

        return "setAttribute";
    }

    @RequestMapping("get")
    public String get(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Object msg = session.getAttribute("msg");

        return "getAttribute: " + msg;
    }
}
