package data_strctures;

import beans.Employee;

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD <-> ");
        while (current != null) {
            System.out.printf("%s <-> ", current);
            current = current.getNext();
        }
        System.out.printf("NULL%n");
    }

    public void removeFromBack() {
        if (size > 0) {
            EmployeeNode remove = tail;
            if (size == 1) {
                head = null;
            } else {
                tail.getPrevious().setNext(null);
            }
            tail = tail.getPrevious();
            size--;
        }
    }

    public void removeFromFront() {
        if (size > 0) {
            if (size == 1) {
                tail = null;
            } else {
                head.getNext().setPrevious(null);
            }
            head = head.getNext();
            size--;
        }
    }

    public void addToBack(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if (size == 0) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        if (size == 0) {
            tail = node;
        } else {
            head.setPrevious(node);
        }
        head = node;
        size++;
    }

    public int getSize() {
        return size;
    }
}
