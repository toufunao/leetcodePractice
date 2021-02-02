package linkedlist;

import java.util.List;
//148题
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head==null)
            return null;

        int len=0;
        ListNode node=head;
        while (node!=null){
            len++;
            node=node.next;
        }

        ListNode dummy=new ListNode(0);
        dummy.next=head;

        for (int i=0;i<len;i*=2){
            ListNode pre=dummy;
            ListNode current=dummy.next;
        }
        return new ListNode();
    }
}
