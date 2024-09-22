package assignment5.ListInterface_Linkedlist;

public class Program5 {

    static Node head1;
    static Node head2;

    public static void add1(int data) {
        Node newNode = new Node(data);
        if (head1 == null) {
            head1 = newNode;
        } else {
            Node current = head1;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public static void add2(int data) {
        Node newNode = new Node(data);
        if (head2 == null) {
            head2 = newNode;
        } else {
            Node current = head2;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public static Node mergeSortedLists(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

       
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next; 
    }

    public static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        add1(1);
        add1(3);
        add1(5);

        add2(2);
        add2(4);
        add2(6);

        System.out.println("List 1:");
        display(head1);

        System.out.println("List 2:");
        display(head2);

        Node mergedHead = mergeSortedLists(head1, head2);
        System.out.println("Merged Sorted List:");
        display(mergedHead);
    }
}