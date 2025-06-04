class Leetcode.이재훈.이재훈.Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        
        current = root
        temp = Node(0) 
        tail = temp
        
        while current:
            if current.left:
                tail.next = current.left
                tail = tail.next
            if current.right:
                tail.next = current.right
                tail = tail.next
            current = current.next
            
            if not current:
                current = temp.next 
                temp.next = None 
                tail = temp
        
        return root