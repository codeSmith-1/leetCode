package linkedListCycleII142;

import java.util.HashSet;
import java.util.Set;

import ListNode.ListNode;

public class detectCycle {

	public static void main(String[] args) {
		// tail loops to 2(index 1)
		
		detectCycle detectApp = new detectCycle();
		ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
		head.next.next.next = head.next;
		
		System.out.println(detectApp.detect(head).val);
	}

	public ListNode detect(ListNode head) {
		if (head == null) {
			return head;
		}
		Set<ListNode> set = new HashSet<>();
		ListNode current = head;

		while (current.next != null) {
			// set.add returns boolean
			if (!set.add(current)) {
				return current;
			} else {
				current = current.next;
			}
		}
		return null;
	}
}
