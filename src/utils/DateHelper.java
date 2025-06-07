package utils;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateHelper {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static String pilihJadwal() {
        List<String> opsiTanggal = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < 5; i++) {
            String tanggal = sdf.format(calendar.getTime());
            opsiTanggal.add(tanggal);
            calendar.add(Calendar.DATE, 1);
        }

        System.out.println("\nPilih Tanggal Keberangkatan:");
        for (int i = 0; i < opsiTanggal.size(); i++) {
            System.out.println((i + 1) + ". " + opsiTanggal.get(i));
        }

        while (true) {
            System.out.print("Masukkan pilihan (1-" + opsiTanggal.size() + "): ");
            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                if (pilihan >= 1 && pilihan <= opsiTanggal.size()) {
                    return opsiTanggal.get(pilihan - 1);
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Pilihan tidak valid. Coba lagi.");
        }
    }
}
