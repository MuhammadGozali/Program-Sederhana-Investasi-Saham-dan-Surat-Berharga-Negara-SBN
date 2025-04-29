# Program-Sederhana-Investasi-Saham-dan-Surat-Berharga-Negara-SBN
Tugas 1 Pemrograman Berorientasi Objek Dosen PengampuWayan Oger Vihikan, S.T.I, M.I.T

# Aplikasi Investasi Java (Saham & Surat Berharga Negara)

Aplikasi konsol sederhana berbasis Java untuk simulasi investasi berupa **saham** dan **Surat Berharga Negara (SBN)**, dengan dua jenis pengguna:
- **Admin**: menambahkan data saham & SBN.
- **Customer**: membeli, menjual saham & SBN, dan melihat portofolio.

## Diagram UML (https://drive.google.com/file/d/1MgrsLlgVWXP-uPjPO-KIyS2py70YYKpW/view?usp=sharing)

## 👨‍💻 Cara Menjalankan Program

### Persyaratan
- JDK versi 8 atau lebih tinggi
- Terminal atau IDE Java seperti IntelliJ IDEA / Eclipse

### Langkah Menjalankan
1. Simpan kode program ke file `InvestasiApp.java`
2. Buka terminal di folder tersebut
3. Compile:
   ```bash
   javac InvestasiApp.java
   ```
4. Jalankan:
   ```bash
   java InvestasiApp
   ```

---

## 🔐 Akun Login Default

| Role    | Username | Password   |
|---------|----------|------------|
| Admin   | admin    | admin123   |
| Customer 1 | cust1    | cust123     |
| Customer 2 | cust2    | cust456     |

---

## 📸 Screenshots

Berikut ini beberapa tangkapan layar skenario aplikasi:

| Skenario                           | Gambar                              |
|------------------------------------|-------------------------------------|
| Login Admin                        | ![Login Admin](https://drive.google.com/file/d/1Xa_UZHLTHk7syeThvM_Qm5yUeraaXqeo/view?usp=drive_link) |
| Tambah Saham                       | ![Tambah Saham](https://drive.google.com/file/d/16x6Twu9p7HvUNDU3wegn-IYoJsdx7iAS/view?usp=drive_link) |
| Login Customer                     | ![Login Customer](https://drive.google.com/file/d/1fwZGILAJhY3h1jG6rfvMePiZb7iV4SXR/view?usp=sharing) |
| Beli Saham                         | ![Beli Saham](https://drive.google.com/file/d/1Q_s-3NHkvxDEzRqyuf26_aKIYwg-fh7M/view?usp=drive_link) |
| Beli SBN                           | ![Beli SBN](https://drive.google.com/file/d/1_-CVpqVj-sLSY7QXS2BEMMX9fMVT34a8/view?usp=drive_link) |
| Simulasi SBN                       | ![Simulasi SBN](https://drive.google.com/file/d/1x-foJWTZ7aDD-w1uczNMtIoRrgAP236M/view?usp=sharing) |
| Lihat Portofolio                   | ![Portofolio](https://drive.google.com/file/d/13pW-NDadfpqeUXDlxrWQ0pVd814yIjYV/view?usp=sharing) |

---

## 📂 Struktur File

```
📁 InvestasiApp/
├── InvestasiApp.java
├── README.md
└── screenshots/
    ├── login_admin.png
    ├── tambah_saham.png
    ├── login_customer.png
    ├── beli_saham.png
    ├── beli_sbn.png
    ├── simulasi_sbn.png
    └── portofolio.png
```

---

## 🛠️ Fitur Utama
- Manajemen saham & SBN oleh admin
- Pembelian dan penjualan saham oleh customer
- Simulasi bunga SBN
- Tampilan portofolio investasi
