class Solution(object):
    def isThree(self, n):
        count = 1
        for i in range(1, n):
            if (n % i) == 0:
                count += 1
                if count > 3: break;
        return count==3
