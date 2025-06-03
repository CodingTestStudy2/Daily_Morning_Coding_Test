package Leetcode.이재훈;

/*
1. 아이디어 :

- maxFreq 을 구하고 맵에 key : num, Value : count
- map의 값을 빼서 maxFreq인것들을 전부 더하기

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / 해쉬맵
 */

public class Q3005 {
    class Solution {
        public int maxFrequencyElements(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int mxFreq = 0;
            for(int num : nums) {
                int freq = map.getOrDefault(num,0) + 1;
                map.put(num,freq );
                mxFreq = Math.max(mxFreq, freq);
            }

            int count =0;
            for (int freq : map.values()) {
                if (freq == mxFreq) {
                    count += freq;
                }
            }
            return count;
        }
    }
}