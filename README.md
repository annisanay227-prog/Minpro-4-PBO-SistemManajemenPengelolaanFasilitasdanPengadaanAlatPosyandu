## **Posyandu - Aplikasi Manajemen Alat Posyandu (Java MVC + JDBC)**

**1. Deskripsi Singkat Program**
Posyandu adalah aplikasi berbasis konsol (CLI) untuk mengelola data alat posyandu. Program menyediakan operasi CRUD (Create, Read, Update, Delete) melalui menu interaktif, dan datanya disimpan di database MySQL db_posyandu menggunakan JDBC.
Program dibangun dengan pola MVC dan menerapkan konsep Pemrograman Berorientasi Objek: encapsulation, inheritance, polymorphism, dan abstraction.
Fitur menu:

<img width="721" height="330" alt="image" src="https://github.com/user-attachments/assets/8a56b72a-56b5-4af7-aa93-4e2c07d3330c" />

**2. Struktur Package**

Posyandu
└── src/main/java
    ├── main
    │   └── main.java
    ├── controller
    │   └── AlatPosyanduController.java
    ├── model
    │   ├── FasilitasPosyandu.java
    │   ├── AlatPosyandu.java
    │   └── PengadaanFasilitas.java
    ├── DAO
    │   ├── AlatDAO.java
    │   └── AlatPosyanduDAOImpl.java
    └── Database
        └── DatabaseConnection.java
  <img width="870" height="447" alt="image" src="https://github.com/user-attachments/assets/b4a2f8c8-4719-47eb-a6ef-474bb74e3dbd" />

  **3. Alur Program**

-Program dijalankan dari main.main, lalu menu ditampilkan berulang sampai pengguna memilih 0.
-Pengguna memilih menu dan memasukkan data bila perlu (nama alat, jumlah, kategori, kondisi).
-main memanggil method pada AlatPosyanduController.
-Controller membuat objek AlatPosyandu dan memanggil method DAO melalui interface AlatDAO (create, readAll, update, delete).
-AlatPosyanduDAOImpl mengambil koneksi dari DatabaseConnection, menjalankan query SQL dengan PreparedStatement, lalu mengembalikan hasilnya.
-Untuk menu Tampilkan Data, hasil ResultSet diubah menjadi List<AlatPosyandu>, lalu controller memanggil tampilkanDetail() pada setiap objek.
-Hasil operasi (berhasil atau gagal) dicetak ke konsol, lalu menu tampil kembali.

**4. Encapsulation dan Inheritance**
*Encapsulation
Atribut pada class model dibungkus dan hanya diakses melalui method Contoh nya ada pada class AlatPosyandu
private String kategori;
private String kondisi;

public String getKategori() { return kategori; }
public String getKondisi() { return kondisi; }
Atribut kategori dan kondisi bersifat private, sehingga tidak bisa diubah langsung dari luar class. Class lain mengambil nilainya lewat getter, misalnya DAO memakai alat.getNama() dan alat.getJumlah() saat menyimpan data. Atribut umum seperti id, nama, dan jumlah diakses lewat getter yang disediakan class induk FasilitasPosyandu.


*Inheritance
AlatPosyandu mewarisi FasilitasPosyandu:
public class AlatPosyandu extends FasilitasPosyandu {
    public AlatPosyandu(int id, String nama, int jumlah, String kategori, String kondisi) {
        super(id, nama, jumlah);
        ...
    }
}

Atribut dan method umum (id, nama, jumlah) didefinisikan sekali di class induk. AlatPosyandu menambahkan atribut khususnya (kategori, kondisi) dan memanggil constructor induk dengan super(...), sehingga kode tidak diulang.



**5. Polymorphism dan Abstraction**
*Abstraction
Interface AlatDAO mendefinisikan operasi data (create, readAll, update, delete) tanpa menjelaskan cara kerjanya. Controller hanya bergantung pada interface ini:

  private final AlatDAO dao;
  this.dao = new AlatPosyanduDAOImpl();
  
Dengan begitu, implementasi penyimpanan bisa diganti tanpa mengubah controller.
Class induk FasilitasPosyandu mendefinisikan method tampilkanDetail() sebagai kerangka perilaku umum yang diwujudkan oleh class turunan.

*Polymorphism
Method tampilkanDetail() di-override oleh AlatPosyandu:
@Override
public void tampilkanDetail() {
    System.out.println("ID: " + id + " | Nama: " + nama + ...);
}

Controller memanggil a.tampilkanDetail() pada setiap objek di dalam list. Method yang dijalankan ditentukan oleh jenis objek sebenarnya saat program berjalan (runtime polymorphism). Selain itu, AlatPosyanduDAOImpl diperlakukan sebagai tipe AlatDAO (polymorphism lewat interface).

**6. Penerapan JDBC**
JDBC (Java Database Connectivity) adalah standar Java untuk menghubungkan program dengan database. Dengan JDBC, program bisa mengirim perintah SQL ke MySQL dan menerima hasilnya
*Dependency pom.xml
Java tidak otomatis tahu cara berbicara dengan MySQL. Library mysql-connector-j adalah driver yang menerjemahkan perintah JDBC menjadi bahasa yang dimengerti MySQL. Maven mengunduhnya otomatis karena ditulis di pom.xml.
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>

*Koneksi DatabaseConnection
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/db_posyandu", "root", "");
    
Class.forName(...) memuat driver MySQL ke memori.
DriverManager.getConnection(...) membuka koneksi ke database. Tiga nilainya:
URL jdbc:mysql://localhost:3306/db_posyandu: MySQL ada di komputer sendiri (localhost), port 3306, database db_posyandu.
User root: akun login MySQL.
Password "": kosong, sesuai bawaan XAMPP.
    
