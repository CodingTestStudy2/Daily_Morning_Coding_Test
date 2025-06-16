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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 둘 다 null이면 종료
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        // 두 노드 중 하나라도 null이면 0으로 간주해서 값을 더함.
        int val1 = (root1 != null) ? root1.val : 0;
        int val2 = (root2 != null) ? root2.val : 0;

        TreeNode newNode = new TreeNode(val1 + val2);

        newNode.left = mergeTrees(
            (root1 != null) ? root1.left : null,
            (root2 != null) ? root2.left : null
        );

        newNode.right = mergeTrees(
            (root1 != null) ? root1.right : null,
            (root2 != null) ? root2.right : null
        );

        return newNode;
    }
}
