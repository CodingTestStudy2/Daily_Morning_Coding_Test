class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        
        def find(current, check, count):
            if count == n:
                print()
                a = []
                for i in current:
                    newarr = "." * (max(0, i)) + "Q" + "." * (max(0, n - i - 1))
                    a.append(newarr)
                result.append(a)

                return 
            
            newset = set()
            newset2 = set()
            for inx, i in enumerate(current):
                if i - (count - inx) >= 0:
                    newset.add(i - (count - inx))
                if i + (count - inx) < n:
                    newset2.add(i + (count - inx))
                    
                    
                    
            for i in range(n):
                if not i in check and not i in newset and not i in newset2:
                    check.add(i)
                    current.append(i)
                    find(current, check, count+1)
                    check.remove(i)
                    current.pop()
                    
            
            
            
            
        find([], set(), 0)
        
        
        return result
            
            