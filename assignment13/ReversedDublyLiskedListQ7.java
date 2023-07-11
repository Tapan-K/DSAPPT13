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

	void reverse() {
		Node current = head;
		Node temp = null;

		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		if (temp != null) {
			head = temp.prev;
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

public class ReversedDublyLiskedListQ7 {

	public static void main(String[] args) {
		// Question 7
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insert(10);
		dll.insert(8);
		dll.insert(4);
		dll.insert(2);

		System.out.print("Original Linked list: ");
		dll.display();

		dll.reverse();

		System.out.print("Reversed Linked list: ");
		dll.display();

	}

}
