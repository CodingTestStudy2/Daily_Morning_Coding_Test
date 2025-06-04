# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Leetcode.이재훈.이재훈.Solution {
    public Set<Integer> getCombinations(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> ans = new HashSet<>();

        for (int num1 : set1) {
            for (int num2 : set2) {
                ans.add(num1 + num2); // 덧셈
                ans.add(num1 - num2); // 뺄셈
                ans.add(num1 * num2); // 곱셈
                if (num2 != 0) {
                    ans.add(num1 / num2); // 나눗셈
                }
            }
        }

        return ans;
    }

    public Set<Integer> get_combinations(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> ans = new HashSet<>();
        return ans;
    }
    public int solution(int N, int number) {
        if (N == number) return 1;

        Set<Integer>[] dp = new HashSet[9];
        for (int i=0; i<9; i++) dp[i] = new HashSet<>();

        for (int i = 1; i<9; i++) {
            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for (int i= 1; i< 9; i++) {
            for (int j = 1; j<i; j++) {
                Set<Integer> set1 = dp[j];
                Set<Integer> set2 = dp[i-j];
                dp[i].addAll(getCombinations(set1, set2));
            }
            if (dp[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
'''


