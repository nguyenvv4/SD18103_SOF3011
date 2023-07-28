package com.example.sd18103.servlet;

import com.example.sd18103.entity.Account;
import com.example.sd18103.service.AuthenticationService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthenticationService authenticationService = new AuthenticationService();
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        Account account =authenticationService.authenticate(username,pass);
        if (account == null){
            response.getWriter().append("Khong tim thay tai khoan");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("username", account.getUsername());
            session.setAttribute("role", account.getRole());

            System.out.println("username: "+ session.getAttribute("username").toString());
            System.out.println("role: "+ session.getAttribute("role").toString());

            // dang nhap thanh cong chuyen trang chu: ca admin lan user deu vao dc
            response.sendRedirect("/san-pham");
        }

    }
}

/*
Giả dụ: trang san-pham : tất cả các quyền đều vào được
 trang home chỉ có role admin được truy cập

 */
