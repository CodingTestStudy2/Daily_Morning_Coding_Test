#

'''
1. 아이디어 :
backtracking으로 왼쪽과 오른쪽 브랜치에 각각 몇개의 노드가 들어갈지 매번 계산한다.

2. 시간복잡도 :
    O(2^n)

3. 자료구조/알고리즘 :
backtracking

'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def allPossibleFBT(self, n: int) -> List[Optional[TreeNode]]:

        # def copy_tree(original_node):
        #     if not original_node:
        #         return

        #     copied = TreeNode(0)
        #     copied.left = copy_tree(original_node.left)
        #     copied.right = copy_tree(original_node.right)

        #     return copied


        def backtrack(nodes):
            
            if nodes == 1: 
                return [TreeNode(0)]

            trees = []
            for left_count in range(1, nodes-1, 2):
                right_count = nodes - 1 - left_count

                left_trees = backtrack(left_count)
                right_trees = backtrack(right_count)
    
                for left_tree in left_trees:
                    for right_tree in right_trees:
                        root = TreeNode(0)
                        root.left = left_tree
                        root.right = right_tree

                        trees.append(root)
            return trees
        
        return backtrack(n)
        

