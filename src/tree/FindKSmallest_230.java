package tree;

public class FindKSmallest_230 {
    int count=0;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;
    }

    public void inOrder(TreeNode treeNode,int k){
        if (treeNode==null)
            return;
        inOrder(treeNode.left,k);
        count++;
        if (count==k)
            ans= treeNode.val;
        else
            inOrder(treeNode.right,k);
    }
}
