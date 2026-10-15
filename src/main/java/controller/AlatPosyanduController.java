package controller;

import DAO.AlatDAO;
import DAO.AlatPosyanduDAOImpl;
import java.util.List;
import model.AlatPosyandu;

public class AlatPosyanduController {
    private final AlatDAO dao;

    public AlatPosyanduController() {
        this.dao = new AlatPosyanduDAOImpl();
    }

    public void tampilkanData() {
        List<AlatPosyandu> list = dao.readAll();
        if (list.isEmpty()) {
            System.out.println(">> Data Alat Posyandu masih kosong.");
        } else {
            for (AlatPosyandu a : list) {
                a.tampilkanDetail(); // Polymorphism
            }
        }
    }

    public void tambahData(String nama, int jumlah, String kategori, String kondisi) {
        dao.create(new AlatPosyandu(0, nama, jumlah, kategori, kondisi));
    }

    public void ubahData(int id, String nama, int jumlah, String kategori, String kondisi) {
        dao.update(new AlatPosyandu(id, nama, jumlah, kategori, kondisi));
    }

    public void hapusData(int id) {
        dao.delete(id);
    }
}