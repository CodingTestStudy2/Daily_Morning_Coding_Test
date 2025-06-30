class Solution:
    def insertIntoMaxTree(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root:
            return 
        
        current = root
        parent = None
        while(current):
            curval = current.val
            if curval < val:
                if parent:
                    newnode = TreeNode(val)
                    parent.right = newnode
                    newnode.left = current
                    return root
                else:
                    newnode = TreeNode(val)
                    newnode.left = current
                    return newnode
            else:
                parent = current
                current = current.right
                
        
        newnode = TreeNode(val)
        parent.right = newnode
        
        return root
                