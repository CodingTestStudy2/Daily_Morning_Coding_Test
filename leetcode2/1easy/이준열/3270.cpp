class Solution {
    public:
        int generateKey(int num1, int num2, int num3) {
            int num1Thous[4] = {0,};
            int num2Thous[4] = {0,};
            int num3Thous[4] = {0,};
            int p = 0;
            int output = 0;
            int div = 1000;
    
            while (div != 0)
            {
                num1Thous[p] = num1 / div;
                num2Thous[p] = num2 / div;
                num3Thous[p] = num3 / div;
                num1 -= num1Thous[p] * div;
                num2 -= num2Thous[p] * div;
                num3 -= num3Thous[p] * div;
                output += div * min(min(num1Thous[p],num2Thous[p]), num3Thous[p]);
    
                div /= 10;
                p++;
            }
            return output;
            
        }
    };