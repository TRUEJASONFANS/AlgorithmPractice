package LeetCode;

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null)
			return head;
		ListNode p1 = head, p2 = head.next;
		while (p2 != null) {
			if (p2.val == val) {
				p1.next = p2.next;
				p2 = p1.next;
			} else {
				p2 = p2.next;
				p1 = p1.next;
			}
		}
		return head;
	}

}
