class Solution {
    int prev = -1;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != -1) {
            min = Math.min(min, root.val - prev);
        }

        prev = root.val;

        inorder(root.right);
    }
}