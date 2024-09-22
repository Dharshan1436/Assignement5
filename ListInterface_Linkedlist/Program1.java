package assignment5.ListInterface_Linkedlist;

class Node {
    int data;
    Node next;
    Node random;
    Node child;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random=null;
        this.child = null;
    }
}

public class Program1 {
    private Node head;

    
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    
    public Node detectCycle() {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;


        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;  
            }
        }

        return null;  
    }

    public static void main(String[] args) {
        Program1 list = new Program1();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

       
        list.head.next.next.next.next.next = list.head.next.next;

        Node startNode = list.detectCycle();

        if (startNode != null) {
            System.out.println("Cycle detected starting at node with data: " + startNode.data);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
