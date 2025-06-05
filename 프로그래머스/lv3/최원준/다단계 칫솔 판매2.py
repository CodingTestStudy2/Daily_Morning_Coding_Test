# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    Map<String, Integer> profits = new HashMap<>();
    Map<String, String> parent = new HashMap<>();
    public void distribute(String curr, Integer profit) {
        if (curr == "-") {
            profits.put(curr, profits.getOrDefault(curr, 0) + profit);
            return;
        }
        int percentage = profit / 10;
        int remain = profit - percentage;
        profits.put(curr, profits.getOrDefault(curr, 0) + remain);
        if (percentage != 0) distribute(parent.get(curr), percentage);
    }

    public int[] solution(String[] enroll, String[] referral, String[] sellers, int[] amounts) {
        for (int i=0; i<enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }
        for (int i=0; i<sellers.length; i++) {
            String seller = sellers[i];
            int amount = amounts[i];
            distribute(seller, amount * 100);
        }
        int[] ans = new int[enroll.length];
        for (int i=0; i<enroll.length; i++) ans[i] = profits.getOrDefault(enroll[i],0);
        return ans;
    }
}

'''

from collections import defaultdict
import math

def solution(enroll, referral, seller, amount):
    def distribute(name, income):
        if name == "-" or income == 0:
            return
        percentage = math.floor(income * 0.1)
        profit[name] += income - percentage
        distribute(par[name], percentage)

    par = {enroll[i] : referral[i] for i in range(len(enroll))}
    profit = defaultdict(int)

    for i in range(len(seller)):
        distribute(seller[i], amount[i] * 100)

    return [profit[person] for person in enroll]