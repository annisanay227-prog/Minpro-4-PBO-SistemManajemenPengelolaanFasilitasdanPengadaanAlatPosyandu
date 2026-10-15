package main;

import controller.AlatPosyanduController;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Memanggil Controller
        AlatPosyanduController controller = new AlatPosyanduController();
        int pilihan;

        do {
            System.out.println("\n=================================");
            System.out.println("   MENU POSYANDU (DENGAN MVC)    ");
            System.out.println("=================================");
            System.out.println("1. Tampilkan Data (Read)");
            System.out.println("2. Tambah Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu [0-4]: ");
            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1 -> {
                    System.out.println("\n--- DAFTAR ALAT POSYANDU ---");
                    controller.tampilkanData();
                }
                case 2 -> {
                    System.out.print("Masukkan Nama Alat: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jumlah: ");
                    int jml = Integer.parseInt(scanner.nextLine());
                    System.out.print("Masukkan Kategori: ");
                    String kat = scanner.nextLine();
                    System.out.print("Masukkan Kondisi: ");
                    String kon = scanner.nextLine();
                    
                    controller.tambahData(nama, jml, kat, kon);
                }
                case 3 -> {
                    System.out.print("Masukkan ID Alat yang ingin diubah: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nama Alat Baru: ");
                    String nama = scanner.nextLine();
                    System.out.print("Jumlah Baru: ");
                    int jml = Integer.parseInt(scanner.nextLine());
                    System.out.print("Kategori Baru: ");
                    String kat = scanner.nextLine();
                    System.out.print("Kondisi Baru: ");
                    String kon = scanner.nextLine();
                    
                    controller.ubahData(id, nama, jml, kat, kon);
                }
                case 4 -> {
                    System.out.print("Masukkan ID Alat yang akan dihapus: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    controller.hapusData(id);
                }
                case 0 -> System.out.println("Terima kasih telah menggunakan program!");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
}