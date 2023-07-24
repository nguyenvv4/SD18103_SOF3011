package com.example.sd18103.servlet;

import com.example.sd18103.entity.SanPham;
import com.example.sd18103.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham",
        "/detailSp",
        "/save",
        "/updateSp",
})
public class SanPhamServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SanPhamRepository sanPhamRepository = new SanPhamRepository();

        if (uri.contains("/san-pham")) {
            ArrayList<SanPham> list = sanPhamRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("san-pham.jsp").forward(request, response);
        } else if (uri.contains("/detailSp")) {
            String id = request.getParameter("id");
            SanPham sanPham = sanPhamRepository.getById(Integer.parseInt(id));
            request.setAttribute("sanPham", sanPham);
            request.getRequestDispatcher("detailSp.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SanPhamRepository sanPhamRepository = new SanPhamRepository();
        if (uri.contains("/save")) {
            SanPham sp = new SanPham();
            try {
                BeanUtils.populate(sp, request.getParameterMap());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            sanPhamRepository.save(sp);
            response.sendRedirect("/san-pham");
        } else if (uri.contains("/updateSp")) {
            String id = request.getParameter("id");
            SanPham spOld = sanPhamRepository.getById(Integer.parseInt(id));
            if (spOld != null) {
                // tien hanh update
                SanPham sp = new SanPham();

                try {
                    BeanUtils.populate(sp, request.getParameterMap());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                sanPhamRepository.update(sp);
                response.sendRedirect("/san-pham");
            } else {
                System.out.println("Khong tim thay");
            }
        }
    }
}
