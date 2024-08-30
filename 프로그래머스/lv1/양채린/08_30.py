def solution(wallpaper):
    answer = []

    for i in range(len(wallpaper)):
        if "#" in wallpaper[i]:
            answer.append(i)
            break

    flag = False
    for j in range(len(wallpaper[0])):
        for i in range(len(wallpaper)):
            if "#" == wallpaper[i][j]:
                answer.append(j)
                flag = True
                break
        if flag:
            break

    for i in range(len(wallpaper) - 1, -1, -1):
        if "#" in wallpaper[i]:
            answer.append(i + 1)
            break

    flag = False
    for j in range(len(wallpaper[0]) - 1, -1, -1):
        for i in range(len(wallpaper)):
            if "#" == wallpaper[i][j]:
                answer.append(j + 1)
                flag = True
                break
        if flag:
            break

    return answer

print(solution([".#...", "..#..", "...#."])) # [0, 1, 3, 4]
print(solution(["..........", ".....#....", "......##..", "...##.....", "....#....."])) # [1, 3, 5, 8]
print(solution([".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."])) # [0, 0, 7, 9]
print(solution(["..", "#."])) # [1, 0, 2, 1]