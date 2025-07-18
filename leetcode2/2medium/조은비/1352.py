class ProductOfNumbers:

    def __init__(self):
        self.que = []
        # 전체 // 부분으로 뒷자리 곱 반환
        self.product = [1]
        self.index = 0

    def add(self, num: int) -> None:
        self.que.append(num)

        if num == 0 or num == 1:
            self.index = len(self.product) - 1
            self.product = [1]
        else:
            self.product.append(self.product[-1] * num) 
        
    def getProduct(self, k: int) -> int:
        # out of range idx 방지
        if k >= len(self.product): return 0
        
        # print(self.index, self.product[-1], self.product[-k-1], result)
        # product = 1
        # for i in range(1, k+1):
        #     # print(k, i, self.que[-i])
        #     if self.que[-1] == 0: return 0
        #     product *= self.que[-i]
        # return product
        result = self.product[-1] // self.product[-k-1]
        return result
        
# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)