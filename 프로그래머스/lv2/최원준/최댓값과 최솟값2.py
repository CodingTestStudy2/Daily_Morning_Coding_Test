# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


def solution(s):
    return str(min(list(map(int,s.split(" "))))) + " " + str(max(list(map(int,s.split(" ")))))

'''
class Leetcode.이재훈.Solution {
    public String solution(String s) {
        int cmin = Integer.MAX_VALUE, cmax = -cmin;
        String[] numStrs = s.split(" ");
        for (String numStr: numStrs){
            int num = Integer.parseInt(numStr);
            cmin = Math.min(cmin, num);
            cmax = Math.max(cmax, num);
        }
        return cmin + " " + cmax;
    }
}
'''