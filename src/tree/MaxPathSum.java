package tree;

public class MaxPathSum {
    int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        calculate(root);
        return sum;

    }

    private int calculate(TreeNode root) {
        if (root==null)
            return 0;
        int leftSum=Math.max(0,calculate(root.left));
        int rightSum=Math.max(0,calculate(root.right));
        int temp=root.val+leftSum+rightSum;
        sum=Math.max(sum,temp);
        return leftSum>rightSum?leftSum+root.val:rightSum+ root.val;
    }
}
