package utils;

import entity.Tiket;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVHelper {

    private static final String FILE_PATH = "web/data/daftar_tiket.csv";

    public static void save(List<Tiket> daftarTiket) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write("ID,Nama,Rute,Tanggal,Tipe\n");

            for (Tiket t : daftarTiket) {
                writer.write(t.getId() + "," +
                        t.getNama() + "," +
                        t.getRute() + "," +
                        t.getTanggal() + "," +
                        t.getTipe() + "\n");
            }

            System.out.println("Data berhasil disimpan ke file: " + FILE_PATH);

        } catch (IOException e) {
            System.out.println("Gagal menyimpan data ke file: " + e.getMessage());
        }
    }

    public static List<Tiket> read() {
        List<Tiket> daftarTiket = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length == 5) {
                    String nama = values[1];
                    String rute = values[2];
                    String tanggal = values[3];
                    String tipe = values[4];

                    Tiket tiket = new Tiket(nama, rute, tanggal, tipe);
                    daftarTiket.add(tiket);
                }
            }
            System.out.println("Data berhasil dimuat dari file: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Gagal memuat data dari file (mungkin file belum ada): " + e.getMessage());
        }

        return daftarTiket;
    }
}
