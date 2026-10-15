package DAO;

import Database.DatabaseConnection;
import model.AlatPosyandu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Mengimplementasikan interface DAO
public class AlatPosyanduDAOImpl implements AlatDAO {

    @Override
    public void create(AlatPosyandu alat) {
        String sql = "INSERT INTO alat_posyandu (nama_alat, jumlah, kategori, kondisi) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, alat.getNama());
            pstmt.setInt(2, alat.getJumlah());
            pstmt.setString(3, alat.getKategori());
            pstmt.setString(4, alat.getKondisi());
            pstmt.executeUpdate();
            System.out.println(">> Berhasil menambahkan data!");
        } catch (SQLException e) {
            System.out.println(">> Gagal menambahkan data: " + e.getMessage());
        }
    }

    @Override
    public List<AlatPosyandu> readAll() {
        List<AlatPosyandu> list = new ArrayList<>();
        String sql = "SELECT * FROM alat_posyandu";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                AlatPosyandu alat = new AlatPosyandu(
                        rs.getInt("id"),
                        rs.getString("nama_alat"),
                        rs.getInt("jumlah"),
                        rs.getString("kategori"),
                        rs.getString("kondisi")
                );
                list.add(alat);
            }
        } catch (SQLException e) {
            System.out.println(">> Gagal mengambil data: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(AlatPosyandu alat) {
        String sql = "UPDATE alat_posyandu SET nama_alat = ?, jumlah = ?, kategori = ?, kondisi = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, alat.getNama());
            pstmt.setInt(2, alat.getJumlah());
            pstmt.setString(3, alat.getKategori());
            pstmt.setString(4, alat.getKondisi());
            pstmt.setInt(5, alat.getId());
            pstmt.executeUpdate();
            System.out.println(">> Berhasil memperbarui data!");
        } catch (SQLException e) {
            System.out.println(">> Gagal memperbarui data: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM alat_posyandu WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(">> Berhasil menghapus data!");
        } catch (SQLException e) {
            System.out.println(">> Gagal menghapus data: " + e.getMessage());
        }
    }
}