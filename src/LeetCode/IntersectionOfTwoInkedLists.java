package LeetCode;

public class IntersectionOfTwoInkedLists {
	

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null ||headB == null) {
			return null;
		}  
        ListNode p1 = headA;
        ListNode p2 = headB;
        int count1=0,count2=0;
        while(p1.next!=null) {
            p1 = p1.next;
            count1++;
        }
        while(p2.next!=null) {
            p2 = p2.next;
            count2++;
        }
        if(p1!=p2) {
            return null;
        }
        int count = Math.abs(count1-count2);
        if(count1>count2) {
            p1 = headA;
            p2 = headB;
        }
        else {
            p1 = headB;
            p2 = headA;
        }
        while(count>0) {
            p1 = p1.next;
            count--;
        }
        while(p1!=null&&p2!=null&&p1!=p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}
