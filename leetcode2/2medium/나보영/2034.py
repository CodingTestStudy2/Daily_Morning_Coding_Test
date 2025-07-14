class StockPrice:

    def __init__(self):
        self.dic = dict()
        self.current0 = 0
        self.maxcehck = 0
        self.mincheck = 10 ** 9 + 1


    def update(self, timestamp: int, price: int) -> None:
        if timestamp in self.dic:
            post = self.dic[timestamp]
            self.dic[timestamp]= price
            if post == self.maxcehck:
                self.maxcehck = max(self.dic.values())
            else:
                self.maxcehck = max(self.maxcehck, price)
            if post == self.mincheck:
                self.mincheck = min(self.dic.values())
            else:
                self.mincheck = min(self.mincheck, price)
        


        else:
            self.current0 = max(timestamp, self.current0)
            self.maxcehck = max(self.maxcehck, price)
            self.mincheck = min(self.mincheck, price)
            self.dic[timestamp] = price
        

    def current(self) -> int:
        return self.dic[self.current0]
        

    def maximum(self) -> int:
        return self.maxcehck

        

    def minimum(self) -> int:
        return self.mincheck