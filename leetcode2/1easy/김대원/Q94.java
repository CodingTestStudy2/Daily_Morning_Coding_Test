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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inOrder(root, answer);
        return answer;
    }

    public void inOrder(TreeNode node, List<Integer> answer) {
        if (node == null) return;
        inOrder(node.left, answer);
        answer.add(node.val);
        inOrder(node.right, answer);
    }
}