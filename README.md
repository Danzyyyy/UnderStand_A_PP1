# Sistem Pemesanan Tiket Travel

Proyek ini merupakan aplikasi berbasis Java sederhana yang mensimulasikan pemesanan tiket travel menggunakan struktur data **Linked List** dan menyimpan datanya ke file `.csv`.

## ✅ Fitur Aplikasi

- Menambahkan tiket ke head, mid, atau tail.
- Menghapus tiket dari head, mid, tail, atau berdasarkan ID.
- Menampilkan semua tiket atau berdasarkan tipe (Executive / Business / Economy).
- Mencari tiket berdasarkan ID.
- Memperbarui rute atau tanggal keberangkatan tiket.
- Menyimpan dan membaca data secara otomatis ke/dari file CSV.

## 📝 Format Data Tiket

Setiap tiket memiliki atribut:

- `id` – ID tiket (unik)
- `nama` – Nama pemesan
- `rute` – Rute keberangkatan (misal: Bandung - Jakarta)
- `tanggal` – Tanggal keberangkatan (format: `dd-MM-yyyy`)
- `tipe` – Tipe tiket: `Executive` atau `Business` atau `Economy` 

Contoh baris pada file `daftar_tiket.csv`:

id,nama,rute,tanggal,tipe
TK001,Budi,Bandung - Jakarta,06-06-2025,Executive
TK002,Siti,Jakarta - Surabaya,07-06-2025,Business

## ▶️ Cara Menjalankan

1. **Clone repositori ini.**
2. **Pastikan folder `src/data/daftar_tiket.csv` sudah tersedia** (akan otomatis dibuat jika belum ada).
3. **Jalankan `Main.java` dari IDE atau terminal.**

## 📦 Catatan Teknis

- Struktur data yang digunakan: **Linked List**
- Data persistensi: File `.csv`
- Format tanggal: `dd-MM-yyyy`
- Tidak menggunakan database eksternal

## 💡 Catatan Tambahan

- Jika data tiket kosong, tiket `Business` hanya boleh ditambahkan setelah ada tiket `Executive`.
- Tanggal keberangkatan dipilih dari daftar tanggal 4 hari ke depan.
- Jika program keluar, data tetap tersimpan di `data/daftar_tiket.csv`.


© 2025 — Proyek Tugas Besar Praktikum Pemrograman 1
