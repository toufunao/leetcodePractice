package linkedlist;

import java.util.List;

public class MergeSortedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;


        ListNode pointer=head;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                pointer.next=l1;
                l1=l1.next;
            }else {
                pointer.next=l2;
                l2=l2.next;
            }
            pointer=pointer.next;
        }
        if (l1==null&&l2!=null)
            pointer.next=l2;
        else if (l2==null&&l1!=null)
            pointer.next=l1;

        return head.next;
    }
    public static void main(String[] args){
        ListNode first=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(4);
        first.next=second;
        second.next=third;

        ListNode a=new ListNode(3);
        ListNode b=new ListNode(6);
        ListNode c=new ListNode(9);
        a.next=b;
        b.next=c;

        ListNode test=mergeTwoLists(first,a);
        while (test.next!=null){
            System.out.print(test.val+" ->");
            test=test.next;
        }
        System.out.print(test.val);
    }
}
