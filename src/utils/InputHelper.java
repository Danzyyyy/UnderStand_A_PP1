package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static String inputTanggal(String prompt) {
        sdf.setLenient(false);
        while (true) {
            System.out.print(prompt + " (format: tanggal-bulan-tahun, Contoh: 03-01-2025): ");
            String input = scanner.nextLine();
            try {
                Date date = sdf.parse(input);
                Date today = sdf.parse(sdf.format(new Date()));

                if (date.before(today)) {
                    System.out.println("Tanggal tidak boleh sebelum hari ini. Coba lagi.");
                    continue;
                }

                return sdf.format(date);
            } catch (ParseException e) {
                System.out.println("Format tidak valid. Coba lagi.");
            }
        }
    }


    public static String inputString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input tidak boleh kosong. Coba lagi.");
        }
    }

    public static int inputInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Coba lagi.");
            }
        }
    }
}
