import services.ListStructure;
import utils.InputHelper;
import utils.MainHelper;


public class Main {
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
                    int pos = InputHelper.inputInt("Masukkan posisi tiket yang ingin dihapus: ");
                    list.removeMid(pos);
                }
                case 7 -> {
                    String id = InputHelper.inputString("Masukkan ID tiket: ");
                    list.searchById(id);
                }
                case 8 -> MainHelper.updateTiket(list);
                case 9 -> {
                    String id = InputHelper.inputString("Masukkan ID tiket: ");
                    list.deleteById(id);
                }
                case 10 -> list.tampilkanSemua();
                case 0 -> System.out.println("Keluar...");
                default -> System.out.println("Menu tidak tersedia.");
            }
        } while (pilih != 0);
    }
}









