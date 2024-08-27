def solution(numbers, hand):
    answer = ''
    hand = hand[0].upper()
    
    def distance_getter(x: str, y: str) -> int:
        keypad = { 
            '1': (0, 0), '2': (0, 1), '3': (0, 2),
            '4': (1, 0), '5': (1, 1), '6': (1, 2),
            '7': (2, 0), '8': (2, 1), '9': (2, 2),
            '*': (3, 0), '0': (3, 1), '#': (3, 2),
        }
        return abs(keypad[x][0] - keypad[y][0]) \
                + abs(keypad[x][1] - keypad[y][1])
    
    l, r = '*', '#'
    for number in numbers:
        if number in [1, 4, 7]: answer += 'L'
        elif number in [3, 6, 9]: answer += 'R'
        else:
            if len(answer) == 0: answer += hand
            else:
                l_distance = distance_getter(str(number), l)
                r_distance = distance_getter(str(number), r)
                if l_distance < r_distance: answer += 'L'
                elif l_distance > r_distance: answer += 'R'
                else: answer += hand
                
        if answer[-1] == 'L': l = str(number)
        else: r = str(number)
    return answer