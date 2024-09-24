/**
* 가장 limit에 가까운 몸무게로 만들어 태우기..!
정렬
[70, 50, 30, 20, 10, 5]
65, 50, 70 3개
100, 85 2개
-> 단순 정렬로 풀 수 없음.
-> 조합해서 풀면 사람 50,000명이므로 안됨

그리디 생각
70, 50, 30, 20, 10, 5
70은 30보다 작은 수 가져오기 100
50은 50보다 작은 수~ 85

50 50 70 80
*/
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n = people.length;
        
        Arrays.sort(people);
        int left = 0, right = n-1;
        
        while (left <= right) {
            int remain = limit - people[right];
            while (remain > 0) {
                if (left > right) break;
                if (remain - people[left] < 0) break;
                
                remain -= people[left];
                left++;
            }
            
            //System.out.println(left + " " + right);
            right--;
            answer++;
        }
        
        return answer;
    }
}