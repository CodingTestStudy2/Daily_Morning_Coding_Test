class StockPrice:
    def __init__(self):
        self.last_timestamp = 0
        self.stream = {} # {timestamp: price}
        self.max_price = -1
        self.min_price = -1

    def update(self, timestamp: int, price: int) -> None:
        self.stream[timestamp] = price

        # ㅇㅎ현재 시간대 까지의 최대최소 구해야함
        # 현재 유효최고가 찾아야...
        if timestamp in self.stream:
            prev_price = self.stream[timestamp]
            
        # {시간: 가격} 에서,,,
        

        # self.last_timestamp = timestamp
        # 기존타임스탬프와 비교하여 더 큰 쪽을 저장
        self.last_timestamp = max(timestamp, self.last_timestamp)


    def current(self) -> int:
        return self.stream[self.last_timestamp]
        
    def maximum(self) -> int:
        return self.max_price

    def minimum(self) -> int:
        return self.min_price
    

# Your StockPrice object will be instantiated and called as such:
# obj = StockPrice()
# obj.update(timestamp,price)
# param_2 = obj.current()
# param_3 = obj.maximum()
# param_4 = obj.minimum()