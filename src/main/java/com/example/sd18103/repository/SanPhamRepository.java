package com.example.sd18103.repository;

import com.example.sd18103.entity.SanPham;
import com.example.sd18103.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;

public class SanPhamRepository {

    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            list = (ArrayList<SanPham>) session.createQuery("from SanPham ").list();
        }
        return list;
    }
}
