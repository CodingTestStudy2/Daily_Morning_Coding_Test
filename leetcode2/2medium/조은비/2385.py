# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def add_graph(self, graph, node, parent):
        if node.val not in graph:
            graph[node.val] = []
        if parent.val not in graph:
            graph[parent.val] = []

        if parent:
            graph[node.val].append(parent.val)
            graph[parent.val].append(node.val)
        print(graph)

    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        # tree인데 그래프
        # 인근노드로 전파.... 그래프의 depth
        graph = {}
        # node = TreeNode()

        self.add_graph(graph, root, None)
