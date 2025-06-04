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
                case 1 -> MainHelper.tambahTiketTail(list);
                case 2 -> MainHelper.tambahTiketHead(list);
                case 3 -> MainHelper.tambahTiketMid(list);
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
                case 8 -> MainHelper.updateTiket(list);
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
}









