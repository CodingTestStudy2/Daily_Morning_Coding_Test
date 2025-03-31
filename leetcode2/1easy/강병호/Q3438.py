class Solution:
    def findValidPair(self, s: str) -> str:
        count_map = dict()
        valid_map = dict()
        
        # 1. count
        for data in s:
            if not data in count_map:
                count_map[data] = 1
            else:
                count_map[data] += 1
            
        for key in count_map:
            if count_map[key] == int(key):
                valid_map[key] = True
            else:
                valid_map[key] = False

        for i in range(len(s)-1):
            char_data = s[i]
            next_char_data = s[i+1]
            if valid_map[char_data] and valid_map[next_char_data] and s[i] != s[i+1]:
                return s[i:i+2]
            elif i == len(s)-2:
                return "" 
        




if __name__ == "__main__":
    sol = Solution()
    print(sol.findValidPair("232"))