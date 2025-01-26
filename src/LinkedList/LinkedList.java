package LinkedList;
import LinkedList.Node;

public class LinkedList {
    public Node head;
    public int length=0;
    void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next=head;
        head = newNode;
        length++;
    }
    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            length++;
        }else {
            Node temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
            length++;
        }
    }
    public void deleteNode(int key) {
        Node temp = head,prev=null;
        if(temp!=null && temp.data==key){
            head=temp.next;
            return;
        }
        while (temp!=null && temp.data!=key){
            prev = temp;
            temp = temp.next;
        }
        if(temp ==null) return;
        prev.next = temp.next;
        length--;
    }
    int search(int key){
        Node temp=head;
        int index=0;
        while (temp!=null){
            if(temp.data==key){
                return index;
            }
            temp=temp.next;
            index++;
        }
        return -1;
    }
    void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    int getLength(){
        return length;
    }
    int getCount(){
        Node temp=head;
        int length=0;
        while (temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    void reverseLinkedList(){
        Node nextNode=null;
        Node currNode=head;
        Node preNode=null;
        while (currNode!=null){
            nextNode=currNode.next;
            currNode.next=preNode;
            preNode=currNode;
            currNode=nextNode;

        }
        head=preNode;
    }
    Node getMiddleNode(Node start, Node end){
        if(start==null) return null;
        Node slow=start;
        Node fast=start;
        while (fast!=end && fast.next!=end){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    boolean binarySearch(int key){
        Node start=head;
        Node end=null;
        while (start!=end){
            Node middle=getMiddleNode(start,end);
            if(middle.data==key) return  true;
            if(key<middle.data) end=middle;
            if(key>middle.data) start=middle.next;
        }
        return false;
    }

    public static void main(String[] args){
        LinkedList list= new LinkedList();
        list.insertAtEnd(12);
        list.insertAtEnd(23);
        list.insertAtEnd(25);
        list.insertAtBeginning(11);
        list.insertAtBeginning(10);
        list.insertAtEnd(27);
        list.insertAtEnd(29);
        System.out.println("Key 25 is at index :: "+list.search(25));
        System.out.println("Linked List length is :: "+list.getLength());
        System.out.println("Linked List length is :: "+list.getCount());
        //Reversing the linked list now
        list.display();
        System.out.println("is element present :: "+list.binarySearch(30));
    }
}