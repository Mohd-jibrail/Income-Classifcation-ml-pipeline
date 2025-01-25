package LinkedList;
import LinkedList.Node;

public class LinkedList {
    public Node head;
    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
        }else {
            Node temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next=head;
        head = newNode;
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
    }
    void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
    }
    public static void main(String[] args){
        LinkedList list= new LinkedList();
        list.insertAtEnd(12);
        list.insertAtEnd(23);
        list.insertAtEnd(25);
        list.insertAtBeginning(11);
        list.deleteNode(12);
        list.deleteNode(23);
        list.display();
    }
}