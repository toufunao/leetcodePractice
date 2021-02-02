package linkedlist;

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode traverse=head;
        int count=0;
        while (traverse!=null){
            count++;
            traverse=traverse.next;
        }
        if (count==0)
            return head;
        k%=count;
        ListNode slow=head;
        ListNode fast=slow;
        int gap=k;
        while (gap!=0){
            gap--;
            fast=fast.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        fast.next=head;
        head=slow.next;
        slow.next=null;

        return head;
    }
}
