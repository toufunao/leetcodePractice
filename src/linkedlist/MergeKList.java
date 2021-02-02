package linkedlist;

import java.util.List;

public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start==end)
            return lists[start];

        if (start>end)
            return null;

        int mid=(start+end)/2;
        return mergeTwoList(merge(lists,start,mid),merge(lists,mid+1,end));
    }

    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode head=new ListNode();
        ListNode p=head;

        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }else {
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }

        if (l1==null&&l2!=null){
            p.next=l2;
        }else if (l2==null&&l1!=null){
            p.next=l1;
        }
        return head.next;
    }
}
