# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        vals = []
        current = head
        if not current:
            return
        while(current):
            vals.append(current.val)
            current = current.next
        

        def maketree(s, f):
            if s > f:
                return None
            else:
                c = (s + f) // 2
                node = TreeNode(vals[c])
                node.left = maketree(s, c -1)
                node.right = maketree(c + 1, f)
                return node


        return maketree(0, len(vals) - 1)