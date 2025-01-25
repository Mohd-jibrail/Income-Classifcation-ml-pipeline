package LinkedList;
import LinkedList.Node;
import LinkedList.LinkedList;

public class MiddleOfLinkedList extends LinkedList {

    public void printMiddle() {
        if (super.head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node slow = super.head;
        Node fast = super.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("The middle element is: " + slow.data);
    }

    public static void main(String[] args) {
        MiddleOfLinkedList list = new MiddleOfLinkedList();
        list.insertAtEnd(12);
        list.insertAtEnd(14);
        list.insertAtEnd(15);
        list.insertAtEnd(16);
        list.insertAtEnd(17);
        list.printMiddle();  // Output: The middle element is: 15
    }
}