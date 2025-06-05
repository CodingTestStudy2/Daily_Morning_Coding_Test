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
    public int[] solution(int k, int[] score) {
        int[] ans =  new int[score.length];
        int ansIdx = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for (int i=0; i<score.length; i++){
            pq.offer(score[i]);
            if (pq.size() == k+1){
                pq.poll();
            }
            ans[ansIdx++] = pq.peek();
        }
        return ans;
    }
}

'''


