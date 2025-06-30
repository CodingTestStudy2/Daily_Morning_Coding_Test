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

    int mDepth;
    Map<Integer, List<Integer>> map;

    public int deepestLeavesSum(TreeNode root) {
        mDepth = -1;
        map = new HashMap<>();
        helper(0, root);
        List<Integer> list = map.get(mDepth);
        int answer = 0;
        for (int x : list) answer += x;
        return answer;
    }

    private void helper(int depth, TreeNode node) {
        if (node == null) return;
        mDepth = Math.max(depth, mDepth);
        map.computeIfAbsent(depth, k -> new ArrayList<>()).add(node.val);

        helper(depth + 1, node.left);
        helper(depth + 1, node.right);
    }
}