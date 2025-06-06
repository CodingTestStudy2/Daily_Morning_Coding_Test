# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Leetcode.이재훈.이재훈.Solution {
    Map<Integer, Integer> ans;
    public Map<Integer, Integer> get_candid(Map<Integer, Integer> prev, int n) {
        Map<Integer, Integer> ans =  new HashMap<>();
        for (var entrySet : prev.entrySet()){
            int key = entrySet.getKey(), val = entrySet.getValue();
            ans.put(key + n, ans.getOrDefault(key + n, 0) + val);
            ans.put(key - n, ans.getOrDefault(key - n, 0) + val);
        }
        return ans;
    }
    public int solution(int[] numbers, int target) {
        ans = new HashMap<>();
        ans.put(0,1);
        for (int num : numbers) ans = get_candid(ans, num);
        return ans.getOrDefault(target, 0);
    }
}

'''


from collections import defaultdict
def solution(numbers, target):
    prev = defaultdict(int)
    prev[0] = 1

    for i, n in enumerate(numbers):
        curr = defaultdict(int)
        for k, v in prev.items():
            curr[k+n] += v
            curr[k-n] += v
        prev = curr
    return prev[target]
