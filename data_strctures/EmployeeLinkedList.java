package data_strctures;

import beans.Employee;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private int size;

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.printf("%s -> ", current);
            current = current.getNext();
        }
        System.out.printf("NULL%n");
    }

    public void removeFromFront() {
        if (size > 0) {
            EmployeeNode remove = head;
            head = remove.getNext();
            size--;
        }
    }

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public int getSize() {
        return size;
    }
}
