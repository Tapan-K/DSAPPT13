package in.ineuron.assignment13;

class Node {
	int data;
	Node prev;
	Node next;

	Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

class DoublyLinkedList {
	Node head;

	void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			newNode.prev = current;
		}
	}

	void deleteNode(int position) {
		if (head == null) {
			return;
		}

		Node current = head;
		int currentPosition = 0;

		if (position == 0) {
			head = current.next;
			if (head != null) {
				head.prev = null;
			}
			return;
		}

		while (current != null && currentPosition < position) {
			current = current.next;
			currentPosition++;
		}

		if (current == null) {
			return;
		}

		if (current.next != null) {
			current.next.prev = current.prev;
		}

		if (current.prev != null) {
			current.prev.next = current.next;
		}
	}

	void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}

public class DeleteNodeDoublyLLQ8 {

	public static void main(String[] args) {
		// Question 8
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insert(1);
		dll.insert(5);
		dll.insert(2);
		dll.insert(9);

		int positionToDelete = 1;

		System.out.print("Original Linked list: ");
		dll.display();

		dll.deleteNode(positionToDelete);

		System.out.print("Linked list after deletion: ");
		dll.display();

	}

}
