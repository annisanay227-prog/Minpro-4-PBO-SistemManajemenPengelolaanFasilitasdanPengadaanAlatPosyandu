package model;

public abstract class FasilitasPosyandu {
    protected int id;
    protected String nama;
    protected int jumlah;

    public FasilitasPosyandu(int id, String nama, int jumlah) {
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public int getJumlah() { return jumlah; }

    public abstract void tampilkanDetail();
}