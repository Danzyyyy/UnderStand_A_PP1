package utils;

import java.util.Scanner;

public class IdGenerator {
    private static int counter = 1;

    public static String generateId() {
        return String.format("TKT%03d", counter++);
    }
}
