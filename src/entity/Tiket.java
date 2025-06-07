package entity;

import utils.IdGenerator;

public class Tiket {
    private String id;
    private String nama;
    private String rute;
    private String tanggal;
    private String tipe;

    public Tiket(String nama, String rute, String tanggal, String tipe) {
        this.id = IdGenerator.generateId();
        this.nama = nama;
        this.rute = rute;
        this.tanggal = tanggal;
        this.tipe = tipe;
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
    public String getTipe() {
        return tipe;
    }

    public void setRute(String rute) {
        this.rute = rute;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}