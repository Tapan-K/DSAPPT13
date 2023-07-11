package in.ineuron.assignment13;
import java.util.*;
import java.io.*;

public class RemoveDuplicatesLinkedListQ2 {
	Node head;
	class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    public void removeDuplicates()
    {
        
        Node curr = head;
 
        /* Traverse list till the last node */
        while (curr != null) {
            Node temp = curr;
           
            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }
           
            curr.next = temp;
            curr = curr.next;
        }
    }
 
    
    public void push(int new_data)
    {
       
        Node new_node = new Node(new_data);
 
       
        new_node.next = head;
 
       
        head = new_node;
    }
 
    
    public void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		RemoveDuplicatesLinkedListQ2 llist = new RemoveDuplicatesLinkedListQ2();
        llist.push(20);
        llist.push(13);
        llist.push(13);
        llist.push(11);
        llist.push(11);
        llist.push(11);
 
        System.out.println(
            "List before removal of duplicates");
        llist.printList();
 
        llist.removeDuplicates();
 
        System.out.println(
            "List after removal of elements");
        llist.printList();

	}

}
