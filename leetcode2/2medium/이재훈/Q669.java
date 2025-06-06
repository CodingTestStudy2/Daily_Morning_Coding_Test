package 이재훈;

/*
1. 아이디어 :
-

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / bst
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Q669 {
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if(root == null) return null;

            if(root.val < low) {
                return trimBST(root.right, low, high);
            }

            if(root.val > high) {
                return trimBST(root.left, low, high);
            }

            root.left = trimBST(root.left, low,high);
            root.right = trimBST(root.right, low,high);

            return root;
        }
    }
}