package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateHelper {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static String inputTanggal(String prompt) {
        sdf.setLenient(false);
        while (true) {
            System.out.print(prompt + " (format: dd-MM-yyyy, Contoh: 25-12-2025): ");
            String input = scanner.nextLine();
            try {
                Date date = sdf.parse(input);
                return sdf.format(date);
            } catch (ParseException e) {
                System.out.println("Format tidak valid. Coba lagi..");
            }
        }
    }
}
