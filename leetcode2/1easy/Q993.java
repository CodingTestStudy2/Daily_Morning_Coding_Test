package Leetcode;

/*
1. 아이디어 :
 - root 부터 레벨에 따라 하나씩 처리하면서 내려간다.
 - 부모노드가 같을경우에는 다시 빼서 처리한다.

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / bfs
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q993 {
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            Deque<TreeNode> q = new ArrayDeque<>();

            q.offer(root);

            while(!q.isEmpty()) {
                int size = q.size();
                boolean isXExisted = false;
                boolean isYExisted = false;
                int t1 = 0;
                int t2 = 0;
                boolean isFamily = false;

                for(int i = 0; i<size;i++) {
                    TreeNode node = q.poll();
                    if(node.val == x) isXExisted =true;

                    if(node.val == y) isYExisted =true;

                    if(node.left != null) q.offer(node.left);
                    if(node.right != null) q.offer(node.right);
                    if(node.left != null && node.right != null) {
                        if((node.left.val == x || node.left.val == y) &&
                                (node.right.val == x || node.right.val == y)) {
                            q.pollLast();
                            q.pollLast();
                            isXExisted = false;
                            isYExisted = false;
                        }
                    }
                }
                if(isXExisted && isYExisted) {
                    return true;
                }
            }
            return false;
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
}

