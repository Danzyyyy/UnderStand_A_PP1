package utils;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateHelper {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static String pilihJadwal() {
        List<String> opsiKeberangkatan = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < 7; i++) {
            String tanggal = sdf.format(calendar.getTime());
            opsiKeberangkatan.add(tanggal + " 08:00");
            opsiKeberangkatan.add(tanggal + " 18:00");
            calendar.add(Calendar.DATE, 1);
        }

        System.out.println("\nPilih Tanggal & Jam Keberangkatan:");
        for (int i = 0; i < opsiKeberangkatan.size(); i++) {
            System.out.println((i + 1) + ". " + opsiKeberangkatan.get(i));
        }

        while (true) {
            System.out.print("Masukkan pilihan (1-" + opsiKeberangkatan.size() + "): ");
            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                if (pilihan >= 1 && pilihan <= opsiKeberangkatan.size()) {
                    return opsiKeberangkatan.get(pilihan - 1);
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Pilihan tidak valid. Coba lagi.");
        }
    }
}
