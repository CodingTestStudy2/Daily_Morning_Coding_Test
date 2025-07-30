class Cashier:

    def __init__(self, n: int, discount: int, products: List[int], prices: List[int]):
        self.n = n
        self.discount = discount
        self.map = {}
        self.products = products
        self.prices = prices
        self.customer = 0

        for i in range(len(products)):
            self.map[self.products[i]] = self.prices[i]
        # print(self.map)
        
    def getBill(self, product: List[int], amount: List[int]) -> float:
        total = 0
        self.customer += 1

        for i in range(len(product)):
            pid = product[i]
            price = self.map[pid] * amount[i]

            total += price

        if self.customer % self.n == 0:
            total *= (100 - self.discount) / 100
        
        return total
        

        


# Your Cashier object will be instantiated and called as such:
# obj = Cashier(n, discount, products, prices)
# param_1 = obj.getBill(product,amount)