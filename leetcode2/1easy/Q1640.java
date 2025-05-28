package Leetcode;

/*
1. 아이디어 :

 - 맵에 데이터 저장 후 돌아가면서 확인

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1640 {
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            Map<Integer, Integer> map = new HashMap<>();

            int idx = 0;
            for(int[] p : pieces) {
                int word = p[0];
                map.put(word, idx++);
            }

            for(int i = 0; i< arr.length; i++) {
                int num = arr[i];

                if(map.containsKey(num)) {
                    int index = map.get(num);
                    int[] array = pieces[index];

                    for(int j = 0; j< array.length;j++) {
                        if(arr[i] != array[j]) return false;
                        if(j< array.length-1) i++;
                    }
                } else {
                    return false;
                }

            }

            return true;
        }
    }
}