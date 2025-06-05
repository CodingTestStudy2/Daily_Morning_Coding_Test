package Leetcode.이재훈;

<<<<<<< HEAD
class Solution {
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; ++i) {
            int first = getFirstDigit(nums[i]);
            for(int j = i + 1; j < nums.length; ++j){
                int last = nums[j] % 10;
                if(gcd(first, last) == 1){
                    count++;
                }
            }
        }
        return count;
    }

    private int getFirstDigit(int n) {
        while (n >= 10) {
            n /= 10;
        }
        return n;
    }

    private int gcd(int a, int b) {
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
=======
/*
1. 아이디어 :

 -

2. 시간복잡도 :
O( n*2 )
3. 자료구조/알고리즘 :
- /
 */

public class Q2748 {
    class Solution {
        public int countBeautifulPairs(int[] nums) {

            int count = 0;
            for(int i = 0; i<nums.length; i++) {
                int firstDigit = getFirstDigit(nums[i]);
                for(int j = i+1; j<nums.length;j++) {
                    int secondDigit = getSecondDigit(nums[j]);
                    if(gcd(firstDigit, secondDigit) == 1) count++;
                }
            }

            return count;
        }

        public int getFirstDigit(int x) {
            // find the first digit

            while(x >= 10) {
                x /= 10;
            }
            return x;
        }

        public int getSecondDigit(int y) {
            return y % 10;
        }

        public int gcd(int x, int y) {
            while(y != 0) {
                int temp = y;
                y = x % y;
                x = temp;
            }

            return x;
        }
    }
}
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
