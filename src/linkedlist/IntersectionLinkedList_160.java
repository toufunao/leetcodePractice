package linkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionLinkedList_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Set<ListNode> set=new HashSet<>();
//        while (headA!=null){
//            set.add(headA);
//            headA=headA.next;
//        }
//        while (headB!=null){
//            if (set.contains(headB))
//                return headB;
//            headB=headB.next;
//        }
//
//        return null;
        if (headA==null||headB==null)
            return null;

        ListNode pA=headA;
        ListNode pB=headB;
        while (pA!=pB){
            if (pA==null){
                pA=headB;
            }else
                pA=pA.next;

            if (pB==null)
                pB=headA;
            else
                pB=pB.next;
        }
        return pA;
    }
}
