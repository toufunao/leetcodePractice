package linkedlist;

public class HasCycle_141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null && fast.next!=null){
            if (fast==slow)
                return true;
            slow=slow.next;
            fast=fast.next.next;
        }

        return true;
    }
}
