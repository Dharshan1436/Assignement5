package assignment5.ListInterface_Linkedlist;

public class Program9 {

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

    public Node reverseInGroups(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node current = head;
        Node prevTail = null;
        Node newHead = null;

        while (true) {
            Node groupHead = current;
            Node prev = null;
            int count = 0;

            while (current != null && count < k) {
                Node nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
                count++;
            }

            if (newHead == null) {
                newHead = prev;
            } else {
                prevTail.next = prev; 
            }
            prevTail = groupHead; 

            if (current == null) break;
            groupHead.next = current; 
        
        }

        return newHead;
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
        Program9 list = new Program9();

        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        
        System.out.println("Original List:");
        list.display(list.getHead());

        int k = 4;
        Node newHead = list.reverseInGroups(list.getHead(), k);
        System.out.println("List after reversing in groups of " + k + ":");
        list.display(newHead);
    }
}
