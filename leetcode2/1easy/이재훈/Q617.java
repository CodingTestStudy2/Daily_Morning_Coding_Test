package Leetcode.이재훈;

/*
1. 아이디어 :

 - root1 이 널일때 root2를 반환한다.
 - root2 가 널일때 root1을 반환한다.
 - 두 노드의 val을 가지고 새로운 노드를 만든 후 노드의 left, right에서 리컬전으로 가지고 온다음에 반환값으로 root을 한다.

2. 시간복잡도 :
O( n*m )
3. 자료구조/알고리즘 :
- /
 */

public class Q617 {
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if(root1 == null) return root2;
            if(root2 == null) return root1;

            TreeNode root = new TreeNode(root1.val + root2.val);


            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);


            return root;

        }
    }
}