def mostVisited(self, n: int, rounds: List[int]) -> List[int]:

        count = [0] * (n + 1) 

    

        for i in range(1, len(rounds)):
            start = rounds[i - 1]
            end = rounds[i]

            while start != end:
                start = (start % n) + 1 
                count[start] += 1

        max_visit = max(count[1:]) 
        return [i for i, c in enumerate(count) if c == max_visit]
