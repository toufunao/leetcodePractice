package tree;

import linkedlist.ListNode;

public class NearestParent_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor=root;
        while (true){
            if (ancestor.val<p.val&&ancestor.val<q.val)
                ancestor=ancestor.right;
            else if (ancestor.val> p.val&&ancestor.val> q.val)
                ancestor=ancestor.left;
            else
                break;
        }
        return ancestor;
    }
}
