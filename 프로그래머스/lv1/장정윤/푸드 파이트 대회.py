# https://school.programmers.co.kr/learn/courses/30/lessons/134240

def solution(food):
    left_word = ''
    
    # 음식이 주어졌을 때 어떻게 문자열 리턴
    # food % 2 해서 몫 넣고, 나머지는 [1:] 자르고, str 뒤집은 값 붙이고
    for i in range(1, len(food)):
        food[i] //= 2
        if food[i] > 0:
            for j in range(food[i]):
                left_word += str(i)
            
    right_word = left_word[::-1]
        
    return left_word + '0' + right_word