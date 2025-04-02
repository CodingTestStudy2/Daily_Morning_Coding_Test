class MapSum:

    def __init__(self):
        self.map_data = dict() 
        
    def insert(self, key: str, val: int) -> None:
        self.map_data[key] = val

    def sum(self, prefix: str) -> int:
        key_list = list(self.map_data.keys())
        result = 0

        for key in key_list:
            if prefix == key[0:len(prefix)]:
                result += self.map_data[key]
            
        
        return result
        


# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)