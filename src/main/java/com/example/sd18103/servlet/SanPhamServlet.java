package com.example.sd18103.servlet;

import com.example.sd18103.entity.SanPham;
import com.example.sd18103.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SanPhamServlet", value = "/home")
public class SanPhamServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPhamRepository sanPhamRepository = new SanPhamRepository();
        ArrayList<SanPham> list = sanPhamRepository.getAll();
        for (SanPham sanPham : list) {
            System.out.println(sanPham.toString());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
