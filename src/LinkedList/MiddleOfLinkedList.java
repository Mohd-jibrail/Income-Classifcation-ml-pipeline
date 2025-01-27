package LinkedList;
import LinkedList.Node;
import LinkedList.LinkedList;

import javax.swing.plaf.nimbus.NimbusStyle;

public class MiddleOfLinkedList extends LinkedList {

    public void printMiddle() {
        if (super.head == null) {
            System.out.println("The list is empty :: ");
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
    void deleteMiddleNode(){
        if (super.head==null){
            System.out.println("The list is empty :: ");
            return;
        }
        if (super.head.next == null) {
            super.head = null;
            return;
        }
        Node slow=super.head;
        Node fast=super.head;
        Node prev=null;
        while (fast != null && fast.next !=null){
           fast=fast.next.next;
           prev=slow;
           slow=slow.next;
        }
        prev.next = slow.next;
    }
    void updateMiddleNode(int data){
        if(super.head==null){
            System.out.println("The List is empty :: ");
            return;
        }
        if(super.head.next==null){
            super.head.data=data;
            return;
        }
        Node slow =super.head;
        Node fast=super.head;
        while (fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.data=data;
    }
    public static void main(String[] args) {
        MiddleOfLinkedList list = new MiddleOfLinkedList();
        list.insertAtEnd(12);
        list.insertAtEnd(14);
        list.insertAtEnd(15);
        list.insertAtEnd(16);
        list.insertAtEnd(17);
        //list.printMiddle();  // Output: The middle element is: 15
        list.display();
        list.deleteMiddleNode();
        list.deleteMiddleNode();
        //list.printMiddle();
        list.display();
        list.printMiddle();
        list.updateMiddleNode(15);
        list.updateMiddleNode(13);
        list.printMiddle();
        list.display();
    }
}