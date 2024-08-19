# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


def solution(m, musicinfos):
    n = len(musicinfos)
    replace_map = {
        "C#":"c",
        "D#":"d",
        "F#":"f",
        "G#":"g",
        "A#":"a",
    }

    def serialize(time):
        hour, minite = time.split(":")
        return int(hour) * 60 + int(minite)

    def duration(start, end):
        return serialize(end) - serialize(start)

    def replace_(s):
        stack = []
        for c in s:
            stack.append(c if c!="#" else replace_map[stack.pop() + c])
        return "".join(stack)

    ans = "(None)"
    cmax = -1
    m = replace_(m)

    for musicinfo in musicinfos:
        start, end, title, code = musicinfo.split(',')
        dur = duration(start, end)
        code = replace_(code)

        if len(code) > dur:
            code = code[:dur]
        else:
            code = code * (dur // len(code)) * 2

        if m in code and dur > cmax:
            cmax = dur
            ans = title

    return ans