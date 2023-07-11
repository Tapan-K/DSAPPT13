package in.ineuron.assignment13;

public class MergedLinkedListQ6 {
	static class Node {
		int key;
		Node next;
	};

	static Node reverseList(Node head) {

		if (head.next == null)
			return head;

		Node rest = reverseList(head.next);
		head.next.next = head;
		head.next = null;

		return rest;
	}

	// Given two non-empty linked lists 'a' and 'b'
	static Node sortedMerge(Node a, Node b) {

		a = reverseList(a);

		b = reverseList(b);

		Node head = null;

		Node temp;

		while (a != null && b != null) {

			if (a.key >= b.key) {

				temp = a.next;

				a.next = head;

				head = a;

				a = temp;
			}

			else {

				temp = b.next;
				b.next = head;
				head = b;
				b = temp;
			}
		}

		while (a != null) {

			temp = a.next;
			a.next = head;
			head = a;
			a = temp;
		}

		while (b != null) {

			temp = b.next;
			b.next = head;
			head = b;
			b = temp;
		}

		return head;
	}

	static void printList(Node Node) {
		while (Node != null) {
			System.out.print(Node.key + " ");
			Node = Node.next;
		}
	}

	/*
	 * Utility function to create a new node with given key
	 */
	static Node newNode(int key) {
		Node temp = new Node();
		temp.key = key;
		temp.next = null;
		return temp;
	}

	public static void main(String[] args) {
		// Question 6
		Node res = null;

		Node a = newNode(5);
		a.next = newNode(10);
		a.next.next = newNode(15);
		a.next.next.next = newNode(40);

		Node b = newNode(2);
		b.next = newNode(3);
		b.next.next = newNode(20);

		/* merge 2 sorted Linked Lists */
		res = sortedMerge(a, b);

		System.out.println("Merged Linked List is:");
		printList(res);

	}

}
