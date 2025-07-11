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
class FindElements {

    private Set<Integer> values = new HashSet<>();

    public FindElements(TreeNode root) {
        init(root, 0);
    }

    public boolean find(int target) {
        return values.contains(target);
    }

    // left != null -> left.val = 2 * x + 1;
    // right != null -> right.val = 2 * x + 2;
    private void init(TreeNode root, int value) {
        if (root == null) return;
        root.val = value;
        values.add(value);

        int v1 = 2 * value + 1;
        init(root.left, v1);

        int v2 = 2 * value + 2;
        init(root.right, v2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */