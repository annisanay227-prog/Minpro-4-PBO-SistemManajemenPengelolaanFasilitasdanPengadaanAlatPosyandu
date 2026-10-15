-- Database Posyandu
CREATE DATABASE IF NOT EXISTS db_posyandu;
USE db_posyandu;

CREATE TABLE IF NOT EXISTS alat_posyandu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama_alat VARCHAR(100) NOT NULL,
    jumlah INT NOT NULL DEFAULT 0,
    kategori VARCHAR(50),
    kondisi VARCHAR(50)
);

-- Data contoh (opsional)
INSERT INTO alat_posyandu (nama_alat, jumlah, kategori, kondisi) VALUES
('Timbangan Bayi', 2, 'Pengukuran', 'Baik'),
('Pengukur Tinggi Badan', 1, 'Pengukuran', 'Baik'),
('Tensimeter', 1, 'Medis', 'Rusak Ringan');
