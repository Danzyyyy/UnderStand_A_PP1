import entity.Tiket;
import services.ListStructure;
import utils.InputHelper;
import utils.MainHelper;
import utils.RuteHelper;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ListStructure list = new ListStructure();

    public static void main(String[] args) {
        int pilih;
        do {

            pilih = MainHelper.menuPilih();

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



    private static void tambahTiketTail() {
        list.insertTail(MainHelper.inputTiketBaru());
        System.out.println("Tiket berhasil ditambahkan (Tail)!");
    }

    private static void tambahTiketHead() {
        list.insertHead(MainHelper.inputTiketBaru());
        System.out.println("Tiket berhasil ditambahkan (Head)!");
    }

    private static void tambahTiketMid() {
        System.out.print("Masukkan posisi penyisipan: ");
        int pos = Integer.parseInt(scanner.nextLine());
        list.insertMid(MainHelper.inputTiketBaru(), pos);
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
