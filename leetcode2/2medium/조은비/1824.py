class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        # 근데 첫 라인은 [1,0,1]
        jumps = []
        maps = [[1,0,1]]

        for ob in obstacles[1:]:
            line = [0]*3
            line[ob-1] = 1
            maps.append(line)
            print(maps)

        # min side jump
        

