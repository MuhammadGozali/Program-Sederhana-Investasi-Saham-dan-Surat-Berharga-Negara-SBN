import java.util.*;

class Saham {
    String kode;
    String namaPerusahaan;
    double harga;

    Saham(String kode, String namaPerusahaan, double harga) {
        this.kode = kode;
        this.namaPerusahaan = namaPerusahaan;
        this.harga = harga;
    }
}

class SuratBerhargaNegara {
    String nama;
    double bunga;
    int jangkaWaktu;
    String tanggalJatuhTempo;
    double kuotaNasional;

    SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, String tanggalJatuhTempo, double kuotaNasional) {
        this.nama = nama;
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }
}

class PortofolioCustomer {
    Map<String, Integer> sahamDimiliki = new HashMap<>();
    Map<String, Double> sbnDimiliki = new HashMap<>();
}

public class InvestasiApp {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Saham> daftarSaham = new HashMap<>();
    static Map<String, SuratBerhargaNegara> daftarSBN = new HashMap<>();
    static Map<String, PortofolioCustomer> portofolio = new HashMap<>();

    static Map<String, String> akunAdmin = Map.of("admin", "admin123");
    static Map<String, String> akunCustomer = Map.of(
            "cust1", "cust123",
            "cust2", "cust456"
    );

    static String currentUser = null;
    static boolean isAdmin = false;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Pilih: ");
            int pilih = getIntInput();
            if (pilih == 1) login();
            else if (pilih == 2) {
                System.out.println("Keluar dari program.");
                break;
            } else {
                System.out.println("Pilihan salah.");
            }
        }
    }

    static void login() {
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        if (akunAdmin.containsKey(user) && akunAdmin.get(user).equals(pass)) {
            isAdmin = true;
            currentUser = user;
            menuAdmin();
        } else if (akunCustomer.containsKey(user) && akunCustomer.get(user).equals(pass)) {
            isAdmin = false;
            currentUser = user;
            portofolio.putIfAbsent(currentUser, new PortofolioCustomer());
            menuCustomer();
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }

    static void menuAdmin() {
        while (true) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Saham");
            System.out.println("2. SBN");
            System.out.println("3. Logout");
            System.out.print("Pilih: ");
            int pilih = getIntInput();
            if (pilih == 1) menuAdminSaham();
            else if (pilih == 2) menuAdminSBN();
            else if (pilih == 3) {
                currentUser = null;
                isAdmin = false;
                break;
            } else {
                System.out.println("Pilihan salah.");
            }
        }
    }

    static void menuAdminSaham() {
        while (true) {
            System.out.println("\n=== ADMIN > SAHAM ===");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Kembali");
            System.out.print("Pilih: ");
            int pilih = getIntInput();
            if (pilih == 1) tambahSaham();
            else if (pilih == 2) ubahHargaSaham();
            else if (pilih == 3) break;
            else System.out.println("Pilihan salah.");
        }
    }

    static void tambahSaham() {
        System.out.print("Kode Saham: ");
        String kode = scanner.nextLine().toUpperCase();
        System.out.print("Nama Perusahaan: ");
        String nama = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = getDoubleInput();
        daftarSaham.put(kode, new Saham(kode, nama, harga));
        System.out.println("Saham berhasil ditambahkan.");
    }

    static void ubahHargaSaham() {
        System.out.print("Kode Saham: ");
        String kode = scanner.nextLine().toUpperCase();
        if (!daftarSaham.containsKey(kode)) {
            System.out.println("Saham tidak ditemukan.");
            return;
        }
        System.out.print("Harga baru: ");
        double harga = getDoubleInput();
        daftarSaham.get(kode).harga = harga;
        System.out.println("Harga saham berhasil diubah.");
    }

    static void menuAdminSBN() {
        while (true) {
            System.out.println("\n=== ADMIN > SBN ===");
            System.out.println("1. Tambah SBN");
            System.out.println("2. Kembali");
            System.out.print("Pilih: ");
            int pilih = getIntInput();
            if (pilih == 1) tambahSBN();
            else if (pilih == 2) break;
            else System.out.println("Pilihan salah.");
        }
    }

    static void tambahSBN() {
        System.out.print("Nama SBN: ");
        String nama = scanner.nextLine();
        System.out.print("Bunga (%): ");
        double bunga = getDoubleInput();
        System.out.print("Jangka Waktu (bulan): ");
        int jangkaWaktu = getIntInput();
        System.out.print("Tanggal Jatuh Tempo: ");
        String tanggal = scanner.nextLine();
        System.out.print("Kuota Nasional: ");
        double kuota = getDoubleInput();
        daftarSBN.put(nama, new SuratBerhargaNegara(nama, bunga, jangkaWaktu, tanggal, kuota));
        System.out.println("SBN berhasil ditambahkan.");
    }

    static void menuCustomer() {
        while (true) {
            System.out.println("\n=== MENU CUSTOMER ===");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Logout");
            System.out.print("Pilih: ");
            int pilih = getIntInput();
            if (pilih == 1) beliSaham();
            else if (pilih == 2) jualSaham();
            else if (pilih == 3) beliSBN();
            else if (pilih == 4) simulasiSBN();
            else if (pilih == 5) lihatPortofolio();
            else if (pilih == 6) {
                currentUser = null;
                break;
            } else {
                System.out.println("Pilihan salah.");
            }
        }
    }

    static void beliSaham() {
        if (daftarSaham.isEmpty()) {
            System.out.println("Belum ada saham yang tersedia.");
            return;
        }
        System.out.println("\n=== DAFTAR SAHAM ===");
        for (Saham saham : daftarSaham.values()) {
            System.out.printf("%s - %s - Rp%.2f%n", saham.kode, saham.namaPerusahaan, saham.harga);
        }
        System.out.print("Masukkan kode saham yang ingin dibeli: ");
        String kode = scanner.nextLine().toUpperCase();
        if (!daftarSaham.containsKey(kode)) {
            System.out.println("Kode saham tidak ditemukan.");
            return;
        }
        System.out.print("Jumlah lembar saham: ");
        int jumlah = getIntInput();
        PortofolioCustomer port = portofolio.get(currentUser);
        port.sahamDimiliki.put(kode, port.sahamDimiliki.getOrDefault(kode, 0) + jumlah);
        System.out.println("Berhasil membeli saham.");
    }

    static void jualSaham() {
        PortofolioCustomer port = portofolio.get(currentUser);
        if (port.sahamDimiliki.isEmpty()) {
            System.out.println("Anda tidak memiliki saham.");
            return;
        }
        System.out.println("\n=== SAHAM DIMILIKI ===");
        for (Map.Entry<String, Integer> entry : port.sahamDimiliki.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " lembar");
        }
        System.out.print("Masukkan kode saham yang ingin dijual: ");
        String kode = scanner.nextLine().toUpperCase();
        if (!port.sahamDimiliki.containsKey(kode)) {
            System.out.println("Anda tidak memiliki saham ini.");
            return;
        }
        System.out.print("Jumlah lembar yang ingin dijual: ");
        int jumlah = getIntInput();
        int milik = port.sahamDimiliki.get(kode);
        if (jumlah > milik) {
            System.out.println("Jumlah lembar melebihi yang dimiliki.");
            return;
        }
        if (jumlah == milik) port.sahamDimiliki.remove(kode);
        else port.sahamDimiliki.put(kode, milik - jumlah);
        System.out.println("Berhasil menjual saham.");
    }

    static void beliSBN() {
        if (daftarSBN.isEmpty()) {
            System.out.println("Belum ada SBN tersedia.");
            return;
        }
        System.out.println("\n=== DAFTAR SBN ===");
        for (SuratBerhargaNegara sbn : daftarSBN.values()) {
            System.out.printf("%s - Kuota: Rp%.2f%n", sbn.nama, sbn.kuotaNasional);
        }
        System.out.print("Masukkan nama SBN yang ingin dibeli: ");
        String nama = scanner.nextLine();
        if (!daftarSBN.containsKey(nama)) {
            System.out.println("SBN tidak ditemukan.");
            return;
        }
        System.out.print("Nominal pembelian: ");
        double nominal = getDoubleInput();
        SuratBerhargaNegara sbn = daftarSBN.get(nama);
        if (nominal > sbn.kuotaNasional) {
            System.out.println("Kuota nasional tidak mencukupi.");
            return;
        }
        sbn.kuotaNasional -= nominal;
        PortofolioCustomer port = portofolio.get(currentUser);
        port.sbnDimiliki.put(nama, port.sbnDimiliki.getOrDefault(nama, 0.0) + nominal);
        System.out.println("Berhasil membeli SBN.");
    }

    static void simulasiSBN() {
        System.out.print("Masukkan nominal investasi: ");
        double nominal = getDoubleInput();
        System.out.print("Masukkan bunga tahunan (%): ");
        double bunga = getDoubleInput();
        double hasil = bunga / 12 / 100 * 0.9 * nominal;
        System.out.printf("Simulasi bunga per bulan: Rp%.2f%n", hasil);
    }

    static void lihatPortofolio() {
        PortofolioCustomer port = portofolio.get(currentUser);
        System.out.println("\n=== PORTOFOLIO ===");
        System.out.println("Saham:");
        if (port.sahamDimiliki.isEmpty()) {
            System.out.println("  (Tidak ada saham)");
        } else {
            for (String kode : port.sahamDimiliki.keySet()) {
                Saham saham = daftarSaham.get(kode);
                int lembar = port.sahamDimiliki.get(kode);
                double totalPembelian = lembar * saham.harga;
                System.out.printf("  %s - %d lembar - Nilai pasar: Rp%.2f%n", kode, lembar, totalPembelian);
            }
        }
        System.out.println("SBN:");
        if (port.sbnDimiliki.isEmpty()) {
            System.out.println("  (Tidak ada SBN)");
        } else {
            for (String nama : port.sbnDimiliki.keySet()) {
                double nominal = port.sbnDimiliki.get(nama);
                SuratBerhargaNegara sbn = daftarSBN.get(nama);
                double bungaBulanan = sbn.bunga / 12 / 100 * 0.9 * nominal;
                System.out.printf("  %s - Rp%.2f - Bunga/bulan: Rp%.2f%n", nama, nominal, bungaBulanan);
            }
        }
    }

    static int getIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Masukkan angka yang valid: ");
                scanner.nextLine();
            }
        }
    }

    static double getDoubleInput() {
        while (true) {
            try {
                double input = scanner.nextDouble();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Masukkan angka desimal yang valid: ");
                scanner.nextLine();
            }
        }
    }
}
