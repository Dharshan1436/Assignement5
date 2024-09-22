package assignment5.ListInterface_Linkedlist;
public class Program8 {

    private Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Node flatten(Node node) {
        if (node == null) return null;

        Node current = node;
        Node tail = node; 

        
        while (current != null) {
            if (current.child != null) {
                
                Node childTail = flatten(current.child);

                
                childTail.next = current.next;
                current.next = current.child; 
                current.child = null; 
            }
            tail = current; 
            current = current.next; 
        }

        return tail; 
    }

    public void display(Node node) {
        Node current = node;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node getHead() {
        return head;
    }

    public static void main(String[] args) {
        Program8 list = new Program8();

        
        list.add(1);
        list.add(2);
        list.add(3);

      
        list.getHead().next.child = new Node(7);
        list.getHead().next.child.next = new Node(8);
        list.getHead().next.child.next.child = new Node(11);
        list.getHead().next.child.next.child.next = new Node(12);

        list.getHead().next.next.child = new Node(4);
        list.getHead().next.next.child.next = new Node(5);
        list.getHead().next.next.child.next.child = new Node(9);
        list.getHead().next.next.child.next.child.next = new Node(10);

        list.getHead().next.next.next = new Node(6);

        System.out.println("Original Multilevel List:");
        list.display(list.getHead());

        list.flatten(list.getHead());
        System.out.println("Flattened List:");
        list.display(list.getHead());
    }
}
