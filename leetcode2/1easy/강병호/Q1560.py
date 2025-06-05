<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution:
=======
class Leetcode.이재훈.Solution:
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    def mostVisited(self, n: int, rounds: list[int]) -> list[int]:
        loc = rounds[0]
        count_map = dict()
        
        for i in range(1, n+1):
            count_map[i] = 0

        count_map[loc] += 1

        for i, section in enumerate(rounds):
            while loc != section:
                # 이동
                if loc == n:
                    loc = 1
                else:
                    loc+=1
                
                count_map[loc] += 1
        

        result = [k for k,v in count_map.items() if max(count_map.values()) == v]

        return result


if __name__ == "__main__":
<<<<<<< HEAD
    sol = Leetcode.이재훈.이재훈.Solution()
=======
    sol = Leetcode.이재훈.Solution()
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    print(sol.mostVisited(4, [1,3,1,2]))
    print(sol.mostVisited(2, [2,1,2,1,2,1,2,1,2]))
    print(sol.mostVisited(7, [1,3,5,7]))
    print(sol.mostVisited(3, [3,2,1,2,1,3,2,1,2,1,3,2,3,1]))