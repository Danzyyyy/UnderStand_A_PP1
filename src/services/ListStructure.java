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
}
