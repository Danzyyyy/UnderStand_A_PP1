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

    public boolean removeHead() {
        if (head != null) {
            head = head.getNext();
            return true;
        }
        return false;
    }

    public boolean removeTail() {
        if (head == null) {
            return false;
        }
        if (head.getNext() == null) {
            head = null;
            return true;
        }
        Node curNode = head;
        while (curNode.getNext().getNext() != null) {
            curNode = curNode.getNext();
        }
        curNode.setNext(null);
        return true;
    }

    public boolean removeMid(int posNode) {
        if (head == null) return false;
        if (posNode <= 1) {
            return removeHead();
        }
        Node curNode = head;
        int i = 1;
        while (curNode.getNext() != null && i < posNode - 1) {
            curNode = curNode.getNext();
            i++;
        }
        if (curNode.getNext() != null) {
            curNode.setNext(curNode.getNext().getNext());
            return true;
        }
        return false;
    }

    public boolean deleteById(String id) {
        Node curNode = head, prev = null;
        while (curNode != null) {
            if (curNode.getData().getId().equals(id)) {
                if (prev == null) {
                    head = curNode.getNext();
                } else {
                    prev.setNext(curNode.getNext());
                }
                return true;
            }
            prev = curNode;
            curNode = curNode.getNext();
        }
        return false;
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

    public void tampilkanByTipe(String tipe) {
        Node curNode = head;
        boolean ditemukan = false;
        System.out.println("\nDaftar Tiket Tipe: " + tipe);
        while (curNode != null) {
            if (curNode.getData().getTipe().equalsIgnoreCase(tipe)) {
                tampilkanTiket(curNode.getData());
                ditemukan = true;
            }
            curNode = curNode.getNext();
        }
        if (!ditemukan) System.out.println("Tidak ada tiket dengan tipe tersebut.");
    }

    public int getSize() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private void tampilkanTiket(Tiket tiket) {
        System.out.println("------------------------------");
        System.out.println("ID Tiket : " + tiket.getId());
        System.out.println("Nama     : " + tiket.getNama());
        System.out.println("Rute     : " + tiket.getRute());
        System.out.println("Tanggal  : " + tiket.getTanggal());
        System.out.println("Tipe     : " + tiket.getTipe());
    }
}
