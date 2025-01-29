package LinkedList;

import LinkedList.LinkedList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
public class SortingOfLinkedList extends LinkedList {
    Node head;
    SortingOfLinkedList(){
        this.head=super.head;
    }
    // Function to sort the linked list using Selection Sort
    public void selectionSort() {
        Node temp = super.head;
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
            ptr1 = super.head;
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
        Node current = super.head;
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
        Node current = super.head;

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
        Node current = super.head;

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
    public void removeDuplicatesInSorted(){
        Node current = super.head;
        while (current!=null && current.next!=null){
            if(current.data==current.next.data){
                current.next=current.next.next;
            } else {
                current=current.next;
            }
        }
    }
    public void removeDuplicatesUnsorted() {
        HashSet<Integer> seen = new HashSet<>();
        Node current = super.head;
        Node prev = null;
        while (current != null) {
            if (seen.contains(current.data)) {
                prev.next = current.next;
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }
    public void moveToFront(){
        if(super.head==null || super.head.next==null) return;
        Node last = super.head;
        Node secondLast = null;
        while (last.next!=null){
            secondLast=last;
            last = last.next;
        }
        secondLast.next=null;
        last.next = head;
        head = last;
    }
    public void moveToLast(){
        Node last=super.head;
        if (last==null || last.next==null) return;
        while (last.next != null){
            last=last.next;
        }
        Node first = super.head;
        Node second = first.next;
        last.next=first;
        first.next=null;
        head=second;
    }
    public static LinkedList addTwoLists(LinkedList first, LinkedList second) {
        Node firstHead = first.head;
        Node secondHead = second.head;
        LinkedList result = new LinkedList();
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        while (firstHead != null || secondHead != null) {
            sum = carry + (firstHead != null ? firstHead.data : 0) + (secondHead != null ? secondHead.data : 0);
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            temp = new Node(sum);

            if (result.head == null) {
                result.head = temp;
            } else {
                assert prev != null;
                prev.next = temp;
            }
            prev = temp;

            if (firstHead != null) {
                firstHead = firstHead.next;
            }
            if (secondHead != null) {
                secondHead = secondHead.next;
            }
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("------Sorting Linked List----");
        SortingOfLinkedList list = new SortingOfLinkedList();
        /**list.insertAtBeginning(14);
        list.insertAtBeginning(13);
        list.insertAtBeginning(12);
        list.insertAtBeginning(12);*/

        // Uncomment the sorting method you want to use
        // list.selectionSort();
        // list.bubbleSort();
        //list.insertionSort();
        list.insertAtEnd(11);
        list.insertAtEnd(12);
        list.insertAtEnd(12);
        list.insertAtEnd(13);

        /**list.display();
        System.out.println("Duplicated in Sorted list :: "+list.findDuplicatesSorted());
        list.removeDuplicatesInSorted();
        list.display();
        list.insertAtEnd(13);
        System.out.println("Duplicated in unsorted list :: "+list.findDuplicatesUnsorted());
        list.display();
        list.removeDuplicatesUnsorted();
        list.display();
        list.moveToFront();
        list.display();
        list.moveToLast();
        list.display();*/
        SortingOfLinkedList list1= new SortingOfLinkedList();
        SortingOfLinkedList list2 = new SortingOfLinkedList();
        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list2.insertAtEnd(1);
        list2.insertAtEnd(3);
        LinkedList list3 = addTwoLists(list1,list2);
        list3.display();
        //System.out.println("Result :: "+list3.data);

    }
}