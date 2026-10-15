package model;

public class PengadaanFasilitas extends FasilitasPosyandu {
    private String sumberDana;
    private String tanggalPengadaan;

    public PengadaanFasilitas(int id, String nama, int jumlah, String sumberDana, String tanggalPengadaan) {
        super(id, nama, jumlah);
        this.sumberDana = sumberDana;
        this.tanggalPengadaan = tanggalPengadaan;
    }

    public String getSumberDana() { return sumberDana; }
    public void setSumberDana(String sumberDana) { this.sumberDana = sumberDana; }

    public String getTanggalPengadaan() { return tanggalPengadaan; }
    public void setTanggalPengadaan(String tanggalPengadaan) { this.tanggalPengadaan = tanggalPengadaan; }

    @Override
    public void tampilkanDetail() {
        System.out.println("ID: " + id + " | Nama: " + nama + " | Jumlah: " + jumlah
                + " | Sumber Dana: " + sumberDana + " | Tanggal: " + tanggalPengadaan);
    }
}