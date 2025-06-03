package entity;

import entity.Tiket;

public class Node {
    private Tiket data;
    private Node next;

    public Node(Tiket data) {
        this.data = data;
    }

    public Tiket getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}