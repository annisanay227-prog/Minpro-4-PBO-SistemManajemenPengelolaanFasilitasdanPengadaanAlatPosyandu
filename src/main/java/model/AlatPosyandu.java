package model;

public class AlatPosyandu extends FasilitasPosyandu {
    private String kategori;
    private String kondisi;

    public AlatPosyandu(int id, String nama, int jumlah, String kategori, String kondisi) {
        super(id, nama, jumlah);
        this.kategori = kategori;
        this.kondisi = kondisi;
    }

    public String getKategori() { return kategori; }
    public String getKondisi() { return kondisi; }

    @Override
    public void tampilkanDetail() {
        System.out.println("ID: " + id + " | Nama: " + nama + " | Jumlah: " + jumlah
                + " | Kategori: " + kategori + " | Kondisi: " + kondisi);
    }
}