def solution(park, routes):
    directions = {"S": [1, 0], "N": [-1, 0], "E": [0, 1], "W": [0, -1]}

    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == "S":
                x, y = i, j

    for route in routes:
        direct, steps = route.split()
        dx, dy = directions[direct]
        steps = int(steps)
        init_x, init_y = x, y

        for _ in range(steps):
            nx, ny = x + dx, y + dy
            
            if nx < 0 or nx >= len(park) or ny < 0 or ny >= len(park[0]) or park[nx][ny] == "X":
                x, y = init_x, init_y
                break
            
            x, y = nx, ny

    return [x, y]