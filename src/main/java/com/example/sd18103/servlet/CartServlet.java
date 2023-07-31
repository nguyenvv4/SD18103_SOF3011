package com.example.sd18103.servlet;

import com.example.sd18103.entity.Cart;
import com.example.sd18103.entity.CartItem;
import com.example.sd18103.entity.SanPham;
import com.example.sd18103.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", value = {
        "/addToCart"
})
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPhamRepository sanPhamRepository = new SanPhamRepository();
        HttpSession session = request.getSession();
        Integer id = Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = sanPhamRepository.getById(id);
        CartItem cartItem = new CartItem();
        cartItem.setIdSp(sanPham.getId());
        cartItem.setTenSp(sanPham.getTen());
        cartItem.setGiaBan(sanPham.getGiaBan());
        cartItem.setSoLuong(1);
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            Cart cartTmp = new Cart();
            List<CartItem> listCartItem = new ArrayList<>();
            listCartItem.add(cartItem);
            cartTmp.setList(listCartItem);
            session.setAttribute("cart", cartTmp);
        } else {
            List<CartItem> list = cart.getList();
            Boolean check = false;
            for (CartItem cartItemTmp : list) {
                if (cartItemTmp.getIdSp() == cartItem.getIdSp()) {
                    cartItemTmp.setSoLuong(cartItemTmp.getSoLuong() + 1);
                    check = true;
                }
            }
            if (!check) {
                list.add(cartItem);
            }
            cart.setList(list);
            session.setAttribute("cart", cart);
        }
        if (cart != null) {
            cart.getList().forEach(x -> System.out.println(x.toString()));
        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
