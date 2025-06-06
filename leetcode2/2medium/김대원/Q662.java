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

    static Map<Integer, List<Integer>> info;

    public int widthOfBinaryTree(TreeNode root) {
        info = new HashMap<>();
        int depth = 0;
        int idx = 1;
        info.computeIfAbsent(depth, k -> new ArrayList<>()).add(idx);
        helper(depth, idx, root);
        int answer = 0;
        for (int key : info.keySet()) {
            List<Integer> list = info.get(key);
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int x : list) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }

            answer = Math.max(answer, max - min + 1);
        }

        return answer;
    }

    private void helper(int depth, int idx, TreeNode node) {
        if (node == null) return;

        if (node.left != null) {
            info.computeIfAbsent(depth + 1, k -> new ArrayList<>()).add(idx * 2 - 1);
            helper(depth + 1, idx * 2, node.left);
        }

        if (node.right != null) {
            info.computeIfAbsent(depth + 1, k -> new ArrayList<>()).add(idx * 2);
            helper(depth + 1, idx * 2 + 1, node.right);
        }
    }
}
