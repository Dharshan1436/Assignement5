package assignment5.ListInterface_Linkedlist;

public class Program7 {

    static Node head;

    public static void add(int data) {
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

    public static void reorderList() {
        

       
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        
        while (secondHalf != null) {
            Node temp1 = firstHalf.next;
            Node temp2 = secondHalf.next;

            firstHalf.next = secondHalf; 
            secondHalf.next = temp1;     
            firstHalf = temp1;           
            secondHalf = temp2;          
        }
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev; 
    }

    public static void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);

        System.out.println("Original List:");
        display();

        reorderList();
        System.out.println("Reordered List:");
        display();
    }
}