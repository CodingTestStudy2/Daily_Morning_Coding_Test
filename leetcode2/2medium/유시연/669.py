# Definition for a binary tree node.
# class 이재훈.TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Leetcode.이재훈.이재훈.Solution:
    def trimBST(self, root: Optional[이재훈.TreeNode], low: int, high: int) -> Optional[이재훈.TreeNode]:
        if root == None:
            return None
        
        if root.val < low:
            return self.trimBST(root.right, low, high)
        
        if root.val > high:
            return self.trimBST(root.left, low, high)


        root.left = self.trimBST(root.left, low, high)
        root.right = self.trimBST(root.right, low, high)
        return root