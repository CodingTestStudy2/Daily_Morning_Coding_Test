'''
겹치는 구간 찾기

마지막 카메라 위치만 기억해주면 됨
[[-20,-15], [-18,-13], [-14,-5], [-5,-3]]
'''
def solution(routes):
    answer = 0
    routes.sort(key=lambda x: x[0])
    # print(routes)
    last_camera = -1e9
    
    for route in routes:
        left, right = route
        
        if last_camera < left:
            answer += 1
            last_camera = right
            # print(last_camera)
    
    return answer