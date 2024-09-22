package assignment5.ListInterface_Linkedlist;

public class Program3 {

    public static Node add(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        return head;
    }

    
    public static Node getIntersectionNode(Node head1, Node head2) {
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        
        if (length1 > length2) {
            head1 = moveAheadBy(head1, length1 - length2);
        } else {
            head2 = moveAheadBy(head2, length2 - length1);
        }


        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;  
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null;  
    }

    
    private static int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    
    private static Node moveAheadBy(Node head, int steps) {
        while (steps > 0 && head != null) {
            head = head.next;
            steps--;
        }
        return head;
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
        
        Node head1 = null;
        head1 = add(head1, 1);
        head1 = add(head1, 2);
        head1 = add(head1, 3);

        Node head2 = null;
        head2 = add(head2, 5);
        head2 = add(head2, 6);

        
        Node intersection = new Node(8);
        head1.next.next.next = intersection;
        head2.next.next = intersection; 

        intersection.next = new Node(9); 

       
        System.out.println("List 1:");
        display(head1);

        System.out.println("List 2:");
        display(head2);

        
        Node intersectNode = getIntersectionNode(head1, head2);
        if (intersectNode != null) {
            System.out.println("Intersection point data: " + intersectNode.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}