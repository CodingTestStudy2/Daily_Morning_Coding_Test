class Solution:
    def __init__(self):
        self.N = None
        self.prices = None
        self.memo = {}

    def dfs(self, idx):
        if idx in self.memo:
            return self.memo[idx]
        
        if idx > (self.N - idx):
            if idx < self.N:
                return self.prices[idx]
            else:
                return 0
        
        min_need = inf
        for next_idx in range(idx+1, 2*idx+3):
            need = self.dfs(next_idx)
            if need < min_need:
                min_need = need
        total_need = self.prices[idx] + min_need
        self.memo[idx] = total_need
        return total_need
        

    def minimumCoins(self, prices: List[int]) -> int:
        self.N = len(prices)
        self.prices = prices
        final_min_need = self.dfs(0)
        return final_min_need