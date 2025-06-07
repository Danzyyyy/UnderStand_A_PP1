package utils;

import entity.Tiket;
import services.ListStructure;

import java.util.List;

public class MainHelper {

    /* ---------- Pilihan Menu Utama ---------- */
    public static int pilihanMenuUtama() {
        System.out.println("\n=== SELAMAT DATANG DI TRAVEL UNDER STAND ===");
        System.out.println("\n=== MENU UTAMA PEMESANAN TIKET ===");
        System.out.println("1. Tambah Pemesanan Tiket");
        System.out.println("2. Hapus Pemesanan Tiket");
        System.out.println("3. Tampilkan Daftar Tiket");
        System.out.println("4. Cari Tiket Berdasarkan ID");
        System.out.println("5. Update Tiket Berdasarkan ID");
        System.out.println("6. Simpan Data ke CSV");          // NEW
        System.out.println("7. Muat Data dari CSV");          // NEW
        System.out.println("0. Keluar");
        return InputHelper.inputInt("Pilih menu: ");
    }

    /* ---------- Pilihan Menu Tambah ---------- */
    public static int pilihanMenuTambah() {
        System.out.println("\n=== MENU TAMBAH TIKET ===");
        System.out.println("1. Tambah Tiket (Executive / Head)");
        System.out.println("2. Tambah Tiket (Business / Mid)");
        System.out.println("3. Tambah Tiket (Economy / Tail)");
        System.out.println("0. Kembali");
        return InputHelper.inputInt("Pilih menu: ");
    }

    /* ---------- Pilihan Menu Hapus ---------- */
    public static int pilihanMenuHapus() {
        System.out.println("\n=== MENU HAPUS TIKET ===");
        System.out.println("1. Hapus Tiket dari Depan (Head)");
        System.out.println("2. Hapus Tiket dari Tengah (Mid)");
        System.out.println("3. Hapus Tiket dari Belakang (Tail)");
        System.out.println("4. Hapus Tiket Berdasarkan ID");
        System.out.println("0. Kembali");
        return InputHelper.inputInt("Pilih menu: ");
    }

    /* ---------- Pilihan Menu Tampilkan ---------- */
    public static int pilihanMenuTampilkan() {
        System.out.println("\n=== MENU TAMPILKAN DAFTAR TIKET ===");
        System.out.println("1. Semua Tiket");
        System.out.println("2. Tiket Executive");
        System.out.println("3. Tiket Business");
        System.out.println("4. Tiket Economy");
        System.out.println("0. Kembali");
        return InputHelper.inputInt("Pilih menu: ");
    }

    /* ---------- INPUT TIKET BARU ---------- */
    public static Tiket inputTiketBaru(String tipe) {
        String nama   = InputHelper.inputString("Masukan nama penumpang: ");
        String rute   = RuteHelper.pilihRute();
        String tanggal = DateHelper.pilihJadwal();

        return new Tiket(nama, rute, tanggal, tipe);
    }

    /* ---------- TAMBAH TIKET SESUAI TIPE ---------- */
    public static void tambahTiketExecutive(ListStructure list) {
        list.insertHead(inputTiketBaru("Executive"));
        System.out.println("Tiket Executive berhasil ditambahkan (Head)!");
        List<Tiket> daftarTiket = list.getAllTickets(); // This method needs to be added to ListStructure
        CSVHelper.simpanKeCSV(daftarTiket);
    }

    public static void tambahTiketBusiness(ListStructure list) {
        if (list.isEmpty()) {
            System.out.println("Tidak dapat menambahkan Tiket Business.");
            System.out.println("Minimal harus ada satu Tiket Executive terlebih dahulu.");
            return;
        } else if (list.getSize() == 1) {
            System.out.println("List hanya berisi 1 tiket, menambahkan sebagai Business di posisi ke-2.");
            list.insertMid(inputTiketBaru("Business"), 2);
        } else {
            int pos = InputHelper.inputInt("Masukkan posisi penyisipan (antara 2 dan " + list.getSize() + "): ");
            list.insertMid(inputTiketBaru("Business"), pos);
            System.out.println("Tiket Business berhasil ditambahkan di posisi " + pos + "!");
        }
        List<Tiket> daftarTiket = list.getAllTickets(); // This method needs to be added to ListStructure
        CSVHelper.simpanKeCSV(daftarTiket);
    }

    public static void tambahTiketEconomy(ListStructure list) {
        list.insertTail(inputTiketBaru("Economy"));
        System.out.println("Tiket Economy berhasil ditambahkan (Tail)!");
        List<Tiket> daftarTiket = list.getAllTickets(); // This method needs to be added to ListStructure
        CSVHelper.simpanKeCSV(daftarTiket);
    }

    /* ---------- UPDATE TIKET ---------- */
    public static void updateTiket(ListStructure list) {
        String id = InputHelper.inputString("Masukkan ID tiket yang ingin diupdate: ");
        String rute = RuteHelper.pilihRute();
        String tanggal = DateHelper.pilihJadwal();
        list.updateById(id, rute, tanggal);
        List<Tiket> daftarTiket = list.getAllTickets(); // This method needs to be added to ListStructure
        CSVHelper.simpanKeCSV(daftarTiket);
    }

    /* ---------- HAPUS TIKET ---------- */
    public static void deleteTiketHead(ListStructure list) {
        if (list.removeHead()) {
            System.out.println("Tiket dari depan (Head) berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus tiket dari depan (list kosong).");
        }
        List<Tiket> daftarTiket = list.getAllTickets(); // This method needs to be added to ListStructure
        CSVHelper.simpanKeCSV(daftarTiket);
    }

    public static void deleteTiketMid(ListStructure list) {
        int pos = InputHelper.inputInt("Masukkan posisi tiket yang ingin dihapus (tengah): ");
        if (list.removeMid(pos)) {
            System.out.println("Tiket pada posisi " + pos + " berhasil dihapus.");
        } else {
            System.out.println("Posisi tidak valid atau tiket tidak ditemukan.");
        }
        List<Tiket> daftarTiket = list.getAllTickets(); // This method needs to be added to ListStructure
        CSVHelper.simpanKeCSV(daftarTiket);
    }

    public static void deleteTiketTail(ListStructure list) {
        if (list.removeTail()) {
            System.out.println("Tiket dari belakang (Tail) berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus tiket dari belakang (list kosong).");
        }
        List<Tiket> daftarTiket = list.getAllTickets(); // This method needs to be added to ListStructure
        CSVHelper.simpanKeCSV(daftarTiket);
    }

    public static void deleteTiketById(ListStructure list) {
        String id = InputHelper.inputString("Masukkan ID tiket: ");
        if (list.deleteById(id)) {
            System.out.println("Tiket dengan ID " + id + " berhasil dihapus.");
        } else {
            System.out.println("Tiket dengan ID " + id + " tidak ditemukan.");
        }
        List<Tiket> daftarTiket = list.getAllTickets(); // This method needs to be added to ListStructure
        CSVHelper.simpanKeCSV(daftarTiket);
    }

    // NEW: Save current tickets to CSV
    public static void saveToCSV(ListStructure list) {
        if (list.isEmpty()) {
            System.out.println("Tidak ada data tiket untuk disimpan.");
            return;
        }

        // Convert linked list to array list for CSV operations
        List<Tiket> daftarTiket = list.getAllTickets(); // This method needs to be added to ListStructure
        CSVHelper.simpanKeCSV(daftarTiket);
    }

    // NEW: Load tickets from CSV
    public static void loadFromCSV(ListStructure list) {
        System.out.println("\nPerhatian: Memuat data dari CSV akan mengganti semua data yang ada saat ini.");
        String konfirmasi = InputHelper.inputString("Lanjutkan? (y/n): ");

        if (konfirmasi.equalsIgnoreCase("y") || konfirmasi.equalsIgnoreCase("yes")) {
            List<Tiket> daftarTiket = CSVHelper.bacaDariCSV();

            if (!daftarTiket.isEmpty()) {
                // Clear current list and load from CSV
                list.clearAll(); // This method needs to be added to ListStructure

                for (Tiket tiket : daftarTiket) {
                    list.insertTail(tiket);
                }

                System.out.println("Data berhasil dimuat dari CSV. Total: " + daftarTiket.size() + " tiket.");
            } else {
                System.out.println("Tidak ada data yang dimuat dari CSV.");
            }
        } else {
            System.out.println("Operasi dibatalkan.");
        }
    }
}
