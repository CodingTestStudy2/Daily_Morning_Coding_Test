/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xResult = new int[] {x, -1, -1};
        int[] yResult = new int[] {y, -1, -1};
        search(0, -1, xResult, yResult, root);

        return xResult[1] == yResult[1] && xResult[2] != yResult[2];
    }

    private void search(int depth, int parent, int[] xResult, int[] yResult, TreeNode node) {
        if (node == null) return;

        if (node.val == xResult[0]) {
            xResult[1] = depth;
            xResult[2] = parent;
        }

        if (node.val == yResult[0]) {
            yResult[1] = depth;
            yResult[2] = parent;
        }

        search(depth + 1, node.val, xResult, yResult, node.left);
        search(depth + 1, node.val, xResult, yResult, node.right);
    }
}