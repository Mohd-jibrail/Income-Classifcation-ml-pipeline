package LinkedList;
import LinkedList.Node;
import LinkedList.LinkedList;

import javax.swing.plaf.nimbus.NimbusStyle;

public class LoopInLinkedList extends LinkedList{
    Node head;
    LoopInLinkedList(){
        this.head=super.head;
    }
    public boolean detectLoop(){
        Node slow=this.head, fast=this.head;
        while (slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public void detectAndRemoveLoop(){
        Node slow=this.head, fast=this.head;
        while (slow != null && fast.next != null){
            slow=slow.next;
            fast=fast.next;
            if(slow==fast){
                removeLoop(slow);
                return;
            }
        }
        System.out.println("The Linked list don't have any Loop.");
    }
    private void removeLoop(Node loopNode){
        Node ptr1=this.head;
        Node ptr2=loopNode;
        while (ptr1.next!=ptr2.next){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        ptr2.next=null;
    }
    public Node detectAndFindLoopStart(){
        Node slow=this.head, fast=this.head;
        while (slow!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow.next==fast.next){
                return findLoopStart(slow);
            }
        }
        return null;
    }
    private Node findLoopStart(Node loopNode){
        Node ptr1=this.head, ptr2=loopNode;
        while (ptr1.next!=ptr2.next){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return ptr1;
    }
    public static void main(String[] args){
        System.out.println("Hello");
        LoopInLinkedList list=new LoopInLinkedList();
        list.insertAtBeginning(12);
        list.insertAtBeginning(13);
        list.reverseLinkedList();
        list.insertAtEnd(14);
        list.display();
        System.out.println("Does linked list has loop :: "+list.detectLoop()+".");
        list.detectAndRemoveLoop();
        System.out.println("Loop start node :: "+list.detectAndFindLoopStart());
    }
}
