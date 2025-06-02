package Leetcode;

/*
1. 아이디어 :

 - 완전탐색으로 하나씩 카운트 해가면서 똑같은 숫자가 3번이상 나오면 false, 아님 return

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

import java.util.HashMap;
import java.util.Map;

public class Q3046 {
    public boolean isPossibleToSplit(int[] nums) {
        // 1 1 2 2 3 4

        // if one element is more than three, return false;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.containsKey(num)) {
                if(map.get(num) > 2) return false;
            }
        }

        return true;
    }
}