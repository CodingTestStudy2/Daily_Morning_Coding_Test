class Leetcode.이재훈.Solution:
    def circularGameLosers(self, n: int, k: int) -> List[int]:
        visited = [False] * n
        visited[0] = True
        turn = 1
        curr_friend = 0
        while True:
            curr_friend = (curr_friend + turn * k) % n
            if not visited[curr_friend]:
                visited[curr_friend] = True
                turn += 1
            else:
                break
        return sorted([i+1 for i, value in enumerate(visited) if not value])