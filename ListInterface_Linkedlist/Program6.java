package assignment5.ListInterface_Linkedlist;

public class Program6 {

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

	public static Node cloneList(Node head) {
		if (head == null)
			return null;

		Node current = head;
		while (current != null) {
			Node newNode = new Node(current.data);
			newNode.next = current.next;
			current.next = newNode;
			current = newNode.next;
		}

		current = head;
		while (current != null) {
			if (current.random != null) {
				current.next.random = current.random.next;
			}
			current = current.next.next;
		}

		Node original = head;
		Node clonedHead = head.next;
		Node clonedCurrent = clonedHead;

		while (original != null) {
			original.next = clonedCurrent.next;
			if (clonedCurrent.next != null) {
				clonedCurrent.next = clonedCurrent.next.next;
			}
			original = original.next;
			clonedCurrent = clonedCurrent.next;
		}

		return clonedHead;
	}

	public static void display(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print("Data: " + current.data);
			if (current.random != null) {
				System.out.print(", Random: " + current.random.data);
			}
			System.out.println();
			current = current.next;
		}
	}

	public static void main(String[] args) {
		add(1);
		add(2);
		add(3);

		head.random = head.next;
		head.next.random = head;
		head.next.next.random = head.next;

		System.out.println("Original List:");
		display(head);

		Node clonedHead = cloneList(head);
		System.out.println("Cloned List:");
		display(clonedHead);
	}
}
