class Solution {
    int total = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return total;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);

        total += Math.abs(left - right);

        return left + right + root.val;
    }
}