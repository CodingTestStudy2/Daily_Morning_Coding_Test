package Leetcode;

/*
1. 아이디어 :

 - fruits 에 있는게 baskets보다 작거나 같은때 담겼다는 의미로 0 으로 바꿔주고
   나중에 0이 아닌게 몇개있는지 세서 값으로 리턴

2. 시간복잡도 :
O( n**2 )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q3477 {
    class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            for(int i = 0; i<fruits.length;i++) {
                for(int j = 0; j<baskets.length; j++) {
                    if(fruits[i] <= baskets[j]) {
                        baskets[j] = 0;
                        break;
                    }
                }
            }
            int count =0;
            for(int j = 0; j<baskets.length; j++) {
                if(baskets[j] != 0) {
                    count++;
                }
            }
            return count;



        }
    }
}