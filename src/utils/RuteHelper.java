package utils;

import java.util.List;
import java.util.Scanner;

public class RuteHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String pilihRute() {
        List<String> ruteList = List.of(
                "Bogor - Bandung",
                "Bandung - Bogor",
                "Bandung - Cicalengka",
                "Cicalengka - Bandung",
                "Bandung - Purwakarta",
                "Purwakarta - Bandung",
                "Bandung - Indramayu",
                "Indramayu - Bandung"
        );

        System.out.println("\nPilih Rute Travel:");
        for (int i = 0; i < ruteList.size(); i++) {
            System.out.println((i + 1) + ". " + ruteList.get(i));
        }

        while (true) {
            System.out.print("Masukkan pilihan (1-" + ruteList.size() + "): ");
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= ruteList.size()) {
                    return ruteList.get(input - 1);
                }
            } catch (NumberFormatException e) {}
            System.out.println("Pilihan tidak valid.");
        }
    }
}