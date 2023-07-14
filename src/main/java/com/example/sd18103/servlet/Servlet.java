package com.example.sd18103.servlet;

import com.example.sd18103.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet(name = "Servlet", value = {
        "/home", // GET
        "/detail", //GET
        "/update", // POST
        "/delete", //POST
        "/add", // POST
})
public class Servlet extends HttpServlet {
    ArrayList<User> list = new ArrayList<>();

    public Servlet() {
        list.add(new User("U1", "Nguyen Van A", 15, "Ha Noi"));
        list.add(new User("U2", "Nguyen Van B", 16, "Ha Noi"));
        list.add(new User("U3", "Nguyen Van C", 17, "Ha Noi"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/home")) {
            request.setAttribute("list", list);
            request.getRequestDispatcher("trang-chu.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            String id = request.getParameter("id");
            User userDetail = new User();
            for (User user : list) {
                if (user.getId().equals(id)) {
                    userDetail = user;
                }
            }
            request.setAttribute("userDetail", userDetail);
            request.getRequestDispatcher("detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            String id = request.getParameter("id");
            User userDetail = new User();
            for (User user : list) {
                if (user.getId().equals(id)) {
                    userDetail = user;
                }
            }
            list.remove(userDetail);
            response.sendRedirect("/home");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/update")) {
            // cách 1.
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            Integer age = Integer.parseInt(request.getParameter("age"));
            String address = request.getParameter("address");
            // cách 2 dùng bean
            User userTmp = new User();
            try {
                BeanUtils.populate(userTmp, request.getParameterMap());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            System.out.println(userTmp.toString());
            for (User user : list) {
                if (user.getId().equals(id)) {
                    user.setName(name);
                    user.setAge(age);
                    user.setAddress(address);
                }
            }
            response.sendRedirect("/home");
        } else if (uri.contains("/add")) {
//            Cach 2: dung bean
//            User userTmp = new User();
//            try {
//                BeanUtils.populate(userTmp, request.getParameterMap());
//                list.add(userTmp);
//                response.sendRedirect("/home");
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            } catch (InvocationTargetException e) {
//                throw new RuntimeException(e);
//            }
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            Integer age = Integer.parseInt(request.getParameter("age"));
            String address = request.getParameter("address");
            User user = new User(id, name, age, address);
            list.add(user);
            response.sendRedirect("/home");

        }
    }
}
