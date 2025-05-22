/*
1. 아이디어 :
- DFS로 돌면서 root1의 왼쪽, root2 오른쪽 및 root1 오른쪽 root2 왼쪽이 같은지 확인하고
- root1의 왼쪽, root2 왼쪽 및 root1 오른쪽 root2 오른쪽이 같은지 확인하고
- 둘 중 하나만 true면 true 반환 아니면 false

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / dfs
 */

public class Q951 {
    class Solution {


        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if(root1 == null && root2 == null) return true;
            if((root1 != null && root2 == null) ||
                    (root1 == null && root2 != null)
            ) return false;

            if(root1.val != root2.val) return false;

            boolean isFlip  = flipEquiv(root1.left, root2.right);
            boolean isFlip2 = flipEquiv(root1.right, root2.left);
            boolean isFlip3 = flipEquiv(root1.left, root2.left);
            boolean isFlip4 = flipEquiv(root1.right, root2.right);

            return (isFlip && isFlip2) || (isFlip3 && isFlip4);
        }

    }
}

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