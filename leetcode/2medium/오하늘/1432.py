# 에러 나서 찾는중
class Leetcode.이재훈.이재훈.Solution:
    def maxDiff(self, num: int) -> int:
        num_str = str(num)
        
        for digit in num_str: # 최대
            if digit != '9':
                max_num = num_str.replace(digit, '9') # 9로 변경
                break
        else:
            max_num = num_str
        
        if num_str[0] != '1': # 최소 첫번째는 1
            min_num = num_str.replace(num_str[0], '1')
        else:
            for digit in num_str[1:]: 
                if digit != '0' and digit != '1':
                    min_num = num_str.replace(digit, '0')
                    break
            else:
                min_num = num_str

        return int(max_num) - int(min_num)
