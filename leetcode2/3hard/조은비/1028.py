# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def recoverFromPreorder(self, traversal: str) -> Optional[TreeNode]:
        # 주어진대로 트리를 만들고 preoder로 순환??
        i = 0
        d = 0
        n = len(traversal)
        tree = {}

        while i < n:
            d = 0
            while i < n and traversal[i] == '-':
                d += 1
                i += 1

            val_s = i
            while i < n and traversal[i] != '-':
                i += 1
            val = int(traversal[val_s:i])

            print(d, ' >> ', val)     
            node = TreeNode(val)
            
            # d 가 0이면 루트
            if d == 0:
                tree[0] = node
            else:
                parent = tree[d-1]
                if parent.left == None:
                    parent.left = node
                else:
                    parent.right = node
                tree[d] = node
                # print(tree)

        return tree[0]
            


        # 디 = 0에 1 - 루트
        # 디 = 1에 2 - 왼
        # 디 = 2에 3 - 왼
        # 디 = 2에 4 - 오
        # 디 = 1에 5 - 오

        # 대시가 나오면 이동
        