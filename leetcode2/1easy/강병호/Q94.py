# Definition for a binary tree node.
# class 이재훈.TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Leetcode.이재훈.이재훈.Solution:
    def inorderTraversal(self, root: Optional[이재훈.TreeNode]) -> list[int]:
        result, stack = [], []
        curr = root
        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            result.append(curr.val)
            curr = curr.right
        return result