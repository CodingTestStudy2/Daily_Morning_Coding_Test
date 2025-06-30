class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        
        def find(current, check, count):
            if count == n:
                result.append(current)
                return 
            
            newset = set()
            for i in check:
                if i - 1 >= 0:
                    newset.add(i-1)
                if i + 1 < n:
                    newset.add(i+1)
                    
                    
                    
            for i in range(n):
                if not i in newset:
                    newset.add(i)
                    newarr = "." * n
                    newarr[i] = "Q"
                    current.append(newarr)
                    find(current, newset, count+1)
                    newset.remove(i)
                    current.remove(count)
                    
            
            
            
            
        find([], set(), 0)
        
        
        return result
            
            