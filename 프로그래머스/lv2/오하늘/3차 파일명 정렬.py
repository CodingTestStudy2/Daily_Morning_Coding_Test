# 답이 안나와 풀이 참고

def solution(files):
    def parse_file(file):
        head, number, tail = '', '', ''
        i = 0
        
        while i < len(file) and not file[i].isdigit(): # head 출력
            head += file[i]
            i += 1
            
        while i < len(file) and file[i].isdigit(): # number
            number += file[i]
            i += 1
        
        return (head, number, file)
        # tail은 두개의 조건만 만족하면 사용하지 않음
            
    parsed_files = []
    for file in files:
        head, number, tail = parse_file(file)
        head_lower = head.lower() # 대소문자 구분 안함
        number_int = int(number)
        parsed_files.append((head_lower, number_int, tail))
        
    sorted_files = sorted(parsed_files, key = lambda x: (x[0], x[1]))
                       
    result = []
    
    for file in sorted_files:
        origin_filename = file[2] # 원본
        result.append(origin_filename)

    return result