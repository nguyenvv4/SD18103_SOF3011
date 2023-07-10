package com.example.sd18103.servlet;

import com.example.sd18103.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    ArrayList<User> list = new ArrayList<>();

    public Servlet() {
        list.add(new User("U1", "Nguyen Van A", 15, "Ha Noi"));
        list.add(new User("U2", "Nguyen Van B", 16, "Ha Noi"));
        list.add(new User("U3", "Nguyen Van C", 17, "Ha Noi"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", list);
        request.getRequestDispatcher("trang-chu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da chay vao day POST");
    }
}
