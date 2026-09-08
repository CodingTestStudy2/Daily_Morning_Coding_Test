'''
실패
'''
from collections import deque

class Solution:
    def allPossibleFBT(self, n: int) -> List[Optional[TreeNode]]:
        queue = deque()
        t = TreeNode()
        t.left = TreeNode()
        t.right = TreeNode()
        queue.append(t)
        count = 3
        ans = []

        if n == 3:
            return [t]

        while True:
            node = []
            while queue:
                node.append(queue.pop())

            for n in node:
                left = TreeNode()
                right = TreeNode()
                left.left = n
                left.right = TreeNode()
                right.right = n
                right.left = TreeNode()
                queue.append(left)
                queue.append(right)
            count+=2

            if count == n:
                break
        
        # print(len(queue))
        return list(queue)