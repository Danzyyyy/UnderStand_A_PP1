import entity.Tiket;
import services.ListStructure;
import utils.InputHelper;
import utils.RuteHelper;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ListStructure list = new ListStructure();

    public static void main(String[] args) {
        int pilih;
        do {
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

            pilih = InputHelper.inputInt("Pilih menu: ");

            switch (pilih) {
                case 1 -> tambahTiketTail();
                case 2 -> tambahTiketHead();
                case 3 -> tambahTiketMid();
                case 4 -> list.removeHead();
                case 5 -> list.removeTail();
                case 6 -> {
                    System.out.print("Masukkan posisi tiket yang ingin dihapus: ");
                    int pos = Integer.parseInt(scanner.nextLine());
                    list.removeMid(pos);
                }
                case 7 -> {
                    System.out.print("Masukkan ID tiket: ");
                    String id = scanner.nextLine();
                    list.searchById(id);
                }
                case 8 -> updateTiket();
                case 9 -> {
                    System.out.print("Masukkan ID tiket: ");
                    String id = scanner.nextLine();
                    list.deleteById(id);
                }
                case 10 -> list.tampilkanSemua();
                case 0 -> System.out.println("Keluar...");
                default -> System.out.println("Menu tidak tersedia.");
            }
        } while (pilih != 0);
    }

    private static Tiket inputTiketBaru() {
        System.out.print("Masukkan nama penumpang: ");
        String nama = scanner.nextLine();
        String rute = RuteHelper.pilihRute();
        String tanggal = InputHelper.inputTanggal("Masukkan tanggal keberangkatan");
        return new Tiket(nama, rute, tanggal);
    }

    private static void tambahTiketTail() {
        list.insertTail(inputTiketBaru());
        System.out.println("Tiket berhasil ditambahkan (Tail)!");
    }

    private static void tambahTiketHead() {
        list.insertHead(inputTiketBaru());
        System.out.println("Tiket berhasil ditambahkan (Head)!");
    }

    private static void tambahTiketMid() {
        System.out.print("Masukkan posisi penyisipan: ");
        int pos = Integer.parseInt(scanner.nextLine());
        list.insertMid(inputTiketBaru(), pos);
        System.out.println("Tiket berhasil ditambahkan (Mid)!");
    }

    private static void updateTiket() {
        System.out.print("Masukkan ID tiket yang ingin diupdate: ");
        String id = scanner.nextLine();
        String rute = RuteHelper.pilihRute();
        String tanggal = InputHelper.inputTanggal("Masukkan tanggal keberangkatan baru");
        list.updateById(id, rute, tanggal);
    }
}
