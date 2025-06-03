'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Leetcode.이재훈.Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0, left = 0, right = people.length-1;

        while (left<=right){
            int total = people[left] + people[right];
            if (total <= limit) {
                left++;
            }
            right --;
            ans ++;
        }
        return ans;
    }
}



'''


