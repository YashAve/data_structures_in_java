import algorithms.Sorting;
import beans.Employee;
import data_strctures.EmployeeDoublyLinkedList;
import data_strctures.EmployeeLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static void doublyLinkedList() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee jimmyBarnes = new Employee("Jimmy", "Barnes", 101);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(mikeWilson);
        list.addToFront(marySmith);
        list.printList();
        list.addToBack(jimmyBarnes);
        list.printList();

        while (list.getSize() > 0) {
            list.removeFromFront();
            list.printList();
        }

        list.addToFront(janeJones);
        list.addToBack(johnDoe);
        list.addToFront(mikeWilson);
        list.addToBack(marySmith);

        list.printList();

        while (list.getSize() > 0) {
            list.removeFromBack();
            list.printList();
        }
    }

    private static void singlyLinkedList() {
        EmployeeLinkedList list = new EmployeeLinkedList();
        list.addToFront(new Employee("Jane", "Jones", 100));
        list.addToFront(new Employee("Sam", "Wilson", 101));
        list.printList();
        System.out.printf("list has %d employees%n", list.getSize());
        list.removeFromFront();
        list.printList();
        list.removeFromFront();
        list.printList();
        list.addToFront(new Employee("Jamie", "Jones", 102));
        list.addToFront(new Employee("Jane", "Jones", 100));
        list.addToFront(new Employee("Sam", "Wilson", 101));
        list.printList();
    }

    private static void arrayList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jane", "Jones", 12));
        employees.add(new Employee("Mark", "Angelo", 14));
        employees.add(new Employee("Jamie", "James", 16));
        for (var employee : employees) {
            System.out.println(employee);
        }
        employees.set(0, new Employee("Bryan", "Adams", 17));
        System.out.println("_".repeat(7));
        employees.add(2, new Employee("Johny", "Sr.", 10));
        System.out.printf("anonymous company has a strength of %d employees%n", employees.size());
        System.out.println("_".repeat(7));
        Employee[] employeesArray = employees.toArray(new Employee[0]);
        for (var employee : employeesArray) {
            System.out.println(employee);
        }
        employees.add(0, new Employee("Jane", "Jones", 12));
        System.out.println("_".repeat(7));
        System.out.println(employees.contains(new Employee("Jane", "Jones", 12)));
        System.out.printf("Jane is the %d employee%n", employees.indexOf(new Employee("Jane", "Jones", 12)) + 1);
    }

    private static void sorting() {
        //int[] array = algorithms.Sorting.getArray(7);
        //array = new int[] {39, 20, 87, 52, 90, 2, 45};
        //array = new int[] {10, 12, 3, 2, 1, 1};
        int[] radixArray = {4792, 4725, 4586, 1330, 8792, 5729};
        System.out.println("array before sorting: " + Arrays.toString(radixArray));
        /*algorithms.Sorting.quickSort(array, 0, array.length);*/
        //algorithms.Sorting.shellSort(array);
        //algorithms.Sorting.quickSort(array, 0, array.length);
        Sorting.radixSort(radixArray, 10, 4);
        //algorithms.Sorting.countingSort(array);
        System.out.println("array after sorting: " + Arrays.toString(radixArray));
    }

    public static void main(String[] args) {
        doublyLinkedList();
        //singlyLinkedList();
        //sorting();
        /*String[] fruits = new String[] {"apple", "banana", "pear", "BANANA"};
        Arrays.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(fruits));*/
        //singlyLinkedList();
        //arrayList();
    }
}