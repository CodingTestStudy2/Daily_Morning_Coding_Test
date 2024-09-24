# https://school.programmers.co.kr/learn/courses/30/lessons/12987

# 런타임 에러
# def solution(A, B):
#     answer = 0
#     # 값이 비슷한 것 끼리 있어야 함
#     a = sorted(A, reverse=True)
#     b = sorted(B, reverse=True)
#     for i in range(len(b)):
#         if a[i] < b[i]:
#             answer += 1
#             a.pop(0)
#             b.pop(0)
#         for j in range(1, len(a)):
#             if b[i] > a[j]:
#                 answer += 1
#                 a.pop(0)
#                 b.pop(0)
#                 break                
#         else:
#             return answer
#     return answer

def solution(A, B):
    answer = 0
    # 값이 비슷한 것 끼리 비교해야 함
    A.sort(reverse = True)
    B.sort(reverse = True)
    
    a_idx, b_idx = 0, 0
    
    while a_idx < len(A) and b_idx < len(B):
        if A[a_idx] < B[b_idx]:
            b_idx += 1
            answer += 1
        a_idx += 1

    return answer