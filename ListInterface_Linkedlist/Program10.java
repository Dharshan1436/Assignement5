package assignment5.ListInterface_Linkedlist;
public class Program10 {

    private static Node head;

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

    public static void removeAllOccurrences(int value) {
        while (head != null && head.data == value) {
            head = head.next; 
        }

        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next; 
            } else {
                current = current.next; 
            }
        }
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
        add(2);
        add(4);
        add(2);
        add(5);

        System.out.println("Original List:");
        display();

        int valueToRemove = 2;
        removeAllOccurrences(valueToRemove);

        System.out.println("List after removing all occurrences of " + valueToRemove + ":");
        display();
    }
}