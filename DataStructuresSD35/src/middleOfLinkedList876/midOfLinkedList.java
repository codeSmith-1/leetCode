package middleOfLinkedList876;

import ListNode.ListNode;

public class midOfLinkedList {

	public static void main(String[] args) {
		midOfLinkedList func = new midOfLinkedList();
		ListNode head = new ListNode(1, new ListNode
									(2, new ListNode
									(3, new ListNode
									(4, new ListNode(5)))));
		
		
		System.out.println(func.findMid(head).val);
	}
	
	public ListNode findMid(ListNode head) {
		int length = 0;
		ListNode pointer = head;
		while (pointer != null) {
			pointer = pointer.next;
			length++;
		}
		pointer = head;
		int mid = length / 2;
		while (mid != 0) {
			pointer = pointer.next;
			mid--;
			// pointer will move 6 spaces because 1 != 0, so 1 - 0 gets it to the second mid
			// node if there were 2
		}
		return pointer;
	}
}
