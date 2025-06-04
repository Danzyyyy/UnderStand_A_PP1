package utils;

import entity.Tiket;
import services.ListStructure;


import entity.Tiket;

public class MainHelper {


    /* ---------- MENU PILIHAN ---------- */

    public static int menuPilih() {
        System.out.println("\n=== MENU PEMESANAN TIKET TRAVEL ===");
        System.out.println("1. Tambah Tiket (Tail)");
        System.out.println("2. Tambah Tiket (Head)");
        System.out.println("3. Tambah Tiket (Mid)");
        System.out.println("4. Hapus Tiket (Head)");
        System.out.println("5. Hapus Tiket (Tail)");
        System.out.println("6. Hapus Tiket (Mid)");
        System.out.println("7. Cari Tiket (berdasarkan ID)");
        System.out.println("8. Update Tiket (berdasarkan ID)");
        System.out.println("9. Hapus Tiket (berdasarkan ID)");
        System.out.println("10. Tampilkan Semua Tiket");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");

        return InputHelper.inputInt("Pilih menu: ");
    }

    /* ---------- INPUT TIKET BARU ---------- */
    public static Tiket inputTiketBaru() {
        String nama   = InputHelper.inputString("Masukan nama penumpang");
        String rute   = RuteHelper.pilihRute();
        String tanggal = InputHelper.inputTanggal("Masukkan tanggal keberangkatan");

        return new Tiket(nama, rute, tanggal);
    }

    /* ---------- TAMBAH TIKET ---------- */

    public static void tambahTiketTail(ListStructure list) {
        list.insertTail(inputTiketBaru());
        System.out.println("Tiket berhasil ditambahkan (Tail)!");
    }

    public static void tambahTiketHead(ListStructure list) {
        list.insertHead(inputTiketBaru());
        System.out.println("Tiket berhasil ditambahkan (Head)!");
    }


}
