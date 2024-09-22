package assignment5.ListInterface_Linkedlist;

public class Program2 {
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

	public static void removeNthFromEnd(int n) {
		Node dummy = new Node(0);
		dummy.next = head;
		Node fast = dummy;
		Node slow = dummy;

		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		head = dummy.next;
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

		int n = 3;
		removeNthFromEnd(n);

		System.out.println("List after removing " + n + "th node from end:");
		display();
	}
}