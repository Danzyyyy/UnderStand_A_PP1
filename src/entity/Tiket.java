package entity;

import utils.IdGenerator;

public class Tiket {
    private String id;
    private String nama;
    private String rute;
    private String tanggal;

    public Tiket(String nama, String rute, String tanggal) {
        this.id = IdGenerator.generateId();
        this.nama = nama;
        this.rute = rute;
        this.tanggal = tanggal;
    }

    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public String getRute() {
        return rute;
    }
    public String getTanggal() {
        return tanggal;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setRute(String rute) {
        this.rute = rute;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}