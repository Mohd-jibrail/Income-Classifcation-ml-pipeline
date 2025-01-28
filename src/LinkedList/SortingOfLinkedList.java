package LinkedList;

import LinkedList.LinkedList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
public class SortingOfLinkedList extends LinkedList {
    Node head;

    SortingOfLinkedList() {
        this.head = super.head;
    }

    // Function to sort the linked list using Selection Sort
    public void selectionSort() {
        Node temp = this.head;
        while (temp != null) {
            Node min = temp;
            Node r = temp.next;
            while (r != null) {
                if (min.data > r.data) {
                    min = r;
                }
                r = r.next;
            }
            int x = temp.data;
            temp.data = min.data;
            min.data = x;
            temp = temp.next;
        }
    }

    // Function to sort the linked list using Bubble Sort
    public void bubbleSort() {
        int swapped;
        Node ptr1;
        Node lptr = null;
        if (this.head == null) {
            return;
        }
        do {
            swapped = 0;
            ptr1 = this.head;
            while (ptr1.next != lptr) {
                if (ptr1.data > ptr1.next.data) {
                    int temp = ptr1.data;
                    ptr1.data = ptr1.next.data;
                    ptr1.next.data = temp;
                    swapped = 1;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        } while (swapped != 0);
    }

    // Function to sort the linked list using Insertion Sort
    public void insertionSort() {
        Node sorted = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            sorted = sortedInsert(sorted, current);
            current = next;
        }
        head = sorted;
    }

    // Function to insert a new node in sorted way in a sorted list
    private Node sortedInsert(Node sorted, Node newNode) {
        if (sorted == null || sorted.data >= newNode.data) {
            newNode.next = sorted;
            sorted = newNode;
        } else {
            Node current = sorted;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        return sorted;
    }
    public List<Integer> findDuplicatesSorted() {
        List<Integer> duplicates = new ArrayList<>();
        Node current = this.head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                duplicates.add(current.data);
            }
            current = current.next;
        }

        return duplicates;
    }
    public List<Integer> findDuplicatesUnsorted() {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> seen = new HashSet<Integer>();
        Node current = this.head;

        while (current != null) {
            if (seen.contains(current.data)) {
                duplicates.add(current.data);
            } else {
                seen.add(current.data);
            }
            current = current.next;
        }

        return duplicates;
    }
    public static void main(String[] args) {
        System.out.println("------Sorting Linked List----");
        SortingOfLinkedList list = new SortingOfLinkedList();
        list.insertAtBeginning(13);
        list.insertAtBeginning(13);
        list.insertAtBeginning(13);
        list.insertAtBeginning(13);

        // Uncomment the sorting method you want to use
        // list.selectionSort();
        // list.bubbleSort();
        //list.insertionSort();
        list.display();
        //System.out.println("Duplicated :: "+list.findDuplicatesSorted());
        System.out.println("Duplicated :: "+list.findDuplicatesUnsorted());

    }
}