package com.example.sd18103.repository;

import com.example.sd18103.entity.SanPham;
import com.example.sd18103.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SanPhamRepository {

    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            list = (ArrayList<SanPham>) session.createQuery("from SanPham ").list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public SanPham getById(Integer id) {
        SanPham result = new SanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            result = session.get(SanPham.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public Boolean save(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        }
    }

    public Boolean update(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sanPham);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        }
    }
}
