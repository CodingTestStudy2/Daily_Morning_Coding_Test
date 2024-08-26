def solution(numbers, hand):
    answer = ''
    
    lst_left_dis = [0, 3]  # '*'
    lst_right_dis = [2, 3] # '#'
    
    for num in numbers:
        # 왼
        if num in [1, 4, 7]:
            lst_left_dis = [0, num // 3] 
            answer += 'L'
        # 오
        elif num in [3, 6, 9]:
            lst_right_dis = [2, num // 3 - 1]
            answer += 'R'
        else:
            # 가운데
            if num == 0:
                cur_dis = [1, 3]
            else:
                cur_dis = [1, num // 3]
            
            left_dis = abs(cur_dis[0] - lst_left_dis[0]) + abs(cur_dis[1] - lst_left_dis[1])
            right_dis = abs(cur_dis[0] - lst_right_dis[0]) + abs(cur_dis[1] - lst_right_dis[1])
            
            if left_dis < right_dis:
                lst_left_dis = cur_dis
                answer += 'L'
            elif left_dis > right_dis:
                lst_right_dis = cur_dis
                answer += 'R'
            else:
                if hand == 'right':
                    lst_right_dis = cur_dis
                    answer += 'R'
                else:
                    lst_left_dis = cur_dis
                    answer += 'L'
    
    return answer
