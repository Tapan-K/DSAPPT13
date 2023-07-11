package in.ineuron.assignment13;

public class ReverseAlternateKLinkedListQ4 {
	static Node head;

	class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node kAltReverse(Node node, int k) {
		Node current = node;
		Node next = null, prev = null;
		int count = 0;

		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (node != null) {
			node.next = current;
		}

		count = 0;
		while (count < k - 1 && current != null) {
			current = current.next;
			count++;
		}

		if (current != null) {
			current.next = kAltReverse(current.next, k);
		}

		return prev;
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	void push(int newdata) {
		Node mynode = new Node(newdata);
		mynode.next = head;
		head = mynode;
	}

	public static void main(String[] args) {
		// Question 4
		ReverseAlternateKLinkedListQ4 list = new ReverseAlternateKLinkedListQ4();

		for (int i = 20; i > 0; i--) {
			list.push(i);
		}
		System.out.println("Given Linked List :");
		list.printList(head);
		head = list.kAltReverse(head, 3);
		System.out.println("");
		System.out.println("Modified Linked List :");
		list.printList(head);

	}

}
