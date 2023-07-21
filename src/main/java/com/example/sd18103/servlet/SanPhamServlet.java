package com.example.sd18103.servlet;

import com.example.sd18103.entity.SanPham;
import com.example.sd18103.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SanPhamServlet", value = "/san-pham")
public class SanPhamServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/san-pham")) {
            SanPhamRepository sanPhamRepository = new SanPhamRepository();
            ArrayList<SanPham> list = sanPhamRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("san-pham.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
