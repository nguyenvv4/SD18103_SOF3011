package com.example.sd18103.repository;

import com.example.sd18103.entity.CTSP;
import com.example.sd18103.entity.SanPham;
import com.example.sd18103.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;

public class ChiTietSanPhamRepository {

    public ArrayList<CTSP> getAll() {
        ArrayList<CTSP> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            list = (ArrayList<CTSP>) session.createQuery("from CTSP ").list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

        ArrayList<CTSP> list = chiTietSanPhamRepository.getAll();
        for (CTSP ctsp : list){
            System.out.println(ctsp.toString());
        }
    }
}
