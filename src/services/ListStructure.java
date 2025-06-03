package services;

import entity.Tiket;
import entity.Node;

public class ListStructure {
    private Node head;

    public void insertTail(Tiket data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node curNode = head;
            while (curNode.getNext() != null) {
                curNode = curNode.getNext();
            }
            curNode.setNext(newNode);
        }
    }

    public void insertHead(Tiket data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void insertMid(Tiket data, int posNode) {
        if (posNode <= 1 || head == null) {
            insertHead(data);
            return;
        }
        Node curNode = head;
        int i = 1;
        while (curNode.getNext() != null && i < posNode - 1) {
            curNode = curNode.getNext();
            i++;
        }
        Node newNode = new Node(data);
        newNode.setNext(curNode.getNext());
        curNode.setNext(newNode);
    }

    public void removeHead() {
        if (head != null) {
            head = head.getNext();
        }
    }

    public void removeTail() {
        if (head == null || head.getNext() == null) {
            head = null;
            return;
        }
        Node curNode = head;
        while (curNode.getNext().getNext() != null) {
            curNode = curNode.getNext();
        }
        curNode.setNext(null);
    }

    public void removeMid(int posNode) {
        if (posNode <= 1 || head == null) {
            removeHead();
            return;
        }
        Node curNode = head;
        int i = 1;
        while (curNode.getNext() != null && i < posNode - 1) {
            curNode = curNode.getNext();
            i++;
        }
        if (curNode.getNext() != null) {
            curNode.setNext(curNode.getNext().getNext());
        }
    }

    public void deleteById(String id) {
        Node curNode = head, prev = null;
        while (curNode != null) {
            if (curNode.getData().getId().equals(id)) {
                if (prev == null) {
                    head = curNode.getNext();
                } else {
                    prev.setNext(curNode.getNext());
                }
                System.out.println("Tiket dengan ID " + id + " berhasil dihapus.");
                return;
            }
            prev = curNode;
            curNode = curNode.getNext();
        }
        System.out.println("Tiket tidak ditemukan.");
    }

    public void searchById(String id) {
        Node curNode = head;
        while (curNode != null) {
            if (curNode.getData().getId().equals(id)) {
                System.out.println("\nTiket ditemukan:");
                tampilkanTiket(curNode.getData());
                return;
            }
            curNode = curNode.getNext();
        }
        System.out.println("Tiket tidak ditemukan.");
    }

    public void updateById(String id, String rute, String tanggal) {
        Node curNode = head;
        while (curNode != null) {
            if (curNode.getData().getId().equals(id)) {
                curNode.getData().setRute(rute);
                curNode.getData().setTanggal(tanggal);
                System.out.println("Tiket berhasil diupdate.");
                return;
            }
            curNode = curNode.getNext();
        }
        System.out.println("Tiket tidak ditemukan.");
    }

    public void tampilkanSemua() {
        Node curNode = head;
        if (curNode == null) {
            System.out.println("Belum ada tiket yang dipesan.");
            return;
        }

        System.out.println("\nDaftar Tiket:");
        while (curNode != null) {
            tampilkanTiket(curNode.getData());
            curNode = curNode.getNext();
        }
    }

    private void tampilkanTiket(Tiket tiket) {
        System.out.println("------------------------------");
        System.out.println("ID Tiket : " + tiket.getId());
        System.out.println("Nama     : " + tiket.getNama());
        System.out.println("Rute     : " + tiket.getRute());
        System.out.println("Tanggal  : " + tiket.getTanggal());
    }
}
