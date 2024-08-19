# https://school.programmers.co.kr/learn/courses/30/lessons/17683

# test 34 failure 모르겠다
def solution(m, musicinfos):
    m = m.replace("C#", "H") \
         .replace("D#", "I") \
         .replace("F#", "J") \
         .replace("G#", "K") \
         .replace("A#", "L")
    answers = []
    for i, musicinfo in enumerate(musicinfos):
        info = musicinfo.split(',')
        start = info[0]
        end = info[1]
        title = info[2]
        note = info[3]
        note = note.replace("C#", "H") \
                   .replace("D#", "I") \
                   .replace("F#", "J") \
                   .replace("G#", "K") \
                   .replace("A#", "L")
        start_hours, start_minutes = map(int, start.split(':'))
        end_hours, end_minutes = map(int, end.split(':'))
        start_time = 60*start_hours + start_minutes
        end_time = 60*end_hours + end_minutes
        time = end_time - start_time
        played_note = note * (time//len(note)) + note[:time%len(note)]
        if m in played_note: 
            answers.append((time, i, title))
    if not answers: return "(None)"
    answer = max(answers, key=lambda x: (x[0], -x[1]))
    return answer[2]

# solution("ABCDEFG", ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"])
print(solution("CC#BCC#BCC#BCC#B", ["03:00,03:30,BAR,CC#B", "03:50,04:20,FOO,CC#BCC#BCC#B", "04:49,05:20,KKK,CC#BCC#BCC#B"]))
# print(solution("ABC", ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]))