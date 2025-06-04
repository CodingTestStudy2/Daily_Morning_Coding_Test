class Leetcode.이재훈.이재훈.Solution:
    def numberOfAlternatingGroups(self, colors: List[int]) -> int:
        count = 0
        for i in range(len(colors)):
            if colors[i-1] != colors[i] and colors[i] != colors[(i+1)%len(colors)]:
                count += 1
        return count
        