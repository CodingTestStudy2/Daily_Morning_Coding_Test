package Leetcode.이재훈;

/*
1. 아이디어 :
 - dfs로 inorder traversal

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / dfs
 */

import 이재훈.TreeNode;

public class Q94 {
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
        private List<Integer> res = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            helper(root);
            return res;
        }

        public void helper(TreeNode root) {
            if(root == null) return;
            helper(root.left);
            res.add(root.val);
            helper(root.right);
        }




    }
}

