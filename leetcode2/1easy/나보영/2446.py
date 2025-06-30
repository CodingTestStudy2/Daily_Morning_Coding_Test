class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        
        startTime1 = event1[0]
        endTime1 = event1[1]
        startTime2 = event2[0]
        endTime2 = event2[1]
        
        #hour
        c1, c2 = map(int, endTime1.split(":"))
        c3, c4 = map(int, startTime2.split(":"))
        k1, k2 = map(int, startTime1.split(":"))
        k3, k4 = map(int, endTime2.split(":"))
        
        if c1 < c3:
            return False
        elif c1 == c3:
            if c2 < c4:
                return False
            elif c2 == c4:
                return True
            else:
                if k1 < c1:
                    return True
                else:
                    if k2 <= c4:
                        return True
                    elif k1 > k3:
                        return False
                    elif k2 <= k4:
                        return True
                    else:
                        return False
                        
        else:
            if k1 < c3:
                return True
            elif k1 == c3:
                if k1 < k3:
                    return True
                else:
                    if k2 > k4:
                        return False
                    else:
                        return True
            else:
                if k1 > k3:
                    return False
                elif k1 < k3:
                    return True
                else:
                    if k2 > k4:
                        return False
                    else:
                        return True
                        
                    
                
                    
        