import services.ListStructure;
import utils.InputHelper;
import utils.MainHelper;

public class Main {
    private static final ListStructure list = new ListStructure();

    public static void main(String[] args) {
        MainHelper.loadFromCSV(list);

        int pilih;
        do {
            pilih = MainHelper.pilihanMenuUtama();

            switch (pilih) {
                case 1 -> {
                    int pilihTambah = MainHelper.pilihanMenuTambah();
                    switch (pilihTambah) {
                        case 1 -> MainHelper.tambahTiketExecutive(list);
                        case 2 -> MainHelper.tambahTiketBusiness(list);
                        case 3 -> MainHelper.tambahTiketEconomy(list);
                        case 0 -> System.out.println("Kembali ke menu utama.");
                        default -> System.out.println("Menu tidak tersedia.");
                    }
                }
                case 2 -> {
                    int pilihHapus = MainHelper.pilihanMenuHapus();
                    switch (pilihHapus) {
                        case 1 -> MainHelper.deleteTiketHead(list);
                        case 2 -> MainHelper.deleteTiketMid(list);
                        case 3 -> MainHelper.deleteTiketTail(list);
                        case 4 -> MainHelper.deleteTiketById(list);
                        case 0 -> System.out.println("Kembali ke menu utama.");
                        default -> System.out.println("Menu tidak tersedia.");
                    }
                }
                case 3 -> {
                    int pilihTampil = MainHelper.pilihanMenuTampilkan();
                    switch (pilihTampil) {
                        case 1 -> list.tampilkanSemua();
                        case 2 -> list.tampilkanByTipe("Executive");
                        case 3 -> list.tampilkanByTipe("Business");
                        case 4 -> list.tampilkanByTipe("Economy");
                        case 0 -> System.out.println("Kembali ke menu utama.");
                        default -> System.out.println("Menu tidak tersedia.");
                    }
                }
                case 4 -> {
                    String id = InputHelper.inputString("Masukkan ID tiket: ");
                    list.searchById(id);
                }
                case 5 -> MainHelper.updateTiket(list);
                case 0 -> System.out.println("Keluar...");
                default -> System.out.println("Menu tidak tersedia.");
            }

        } while (pilih != 0);
    }
}
