class Solution:
    def robotSim(self, commands: list[int], obstacles: list[list[int]]) -> int:

        # obstacles 만나면 멈춤
        # -> -2 turn left ++
        # <- -1 turn right --
        # N L S R
        dx = [0, -1, 0, 1]
        dy = [1, 0, -1, 0]
        result = 0
        x, y = 0, 0
        direction = 0

        obstacles_set = set((i, j) for i, j in obstacles)
    
        for command in commands:
            if command == -2:
                direction = (direction + 1) % 4
            elif command == -1:
                direction = (direction - 1) % 4
            else:
                for _ in range(command):
                    n_y = y + dy[direction]
                    n_x = x + dx[direction]

                    if (n_x, n_y) in obstacles_set:
                        # 장애물 존재
                        break
                    
                    # 위치 저장
                    x = n_x
                    y = n_y

                    curr = pos[1]*pos[1] + pos[0] * pos[0]

                    if curr > result:
                        result = curr
        
        return result


            

