# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public String solution(String s) {
        String sentence = " " + s;
        String ans = "";
        
        for (int i=1; i<sentence.length(); i++) {
            char prev = sentence.charAt(i-1), curr = sentence.charAt(i);
            if (prev == ' ' && Character.isAlphabetic(curr)) {
                ans += Character.toUpperCase(curr);
            } else if (Character.isAlphabetic(curr)) {
                ans += Character.toLowerCase(curr);
            } else {
                ans += curr;
            }
        }
        return ans;
    }
}'''