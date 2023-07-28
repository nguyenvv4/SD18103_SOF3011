package com.example.sd18103.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// đường dẫn nào cần phân quyền thì filter đường dẫn đó
@WebFilter("/home")
public class AdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        // kiêm tra có phải quyền admin hay khong
        if (session.getAttribute("role") == null) {
            response.getWriter().append("Ban khong co quyen truy cap");
        } else if (session.getAttribute("role").equals("Admin")) {
            // neu dung quyen thi cho mo trang
            chain.doFilter(request, response);
        } else {
            response.getWriter().append("Ban khong co quyen Admin");
        }

    }
}
