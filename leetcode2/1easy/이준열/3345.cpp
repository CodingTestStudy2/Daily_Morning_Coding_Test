class Solution {
    public:
        int getProductDigit(int target)
        {
            int output = 0;
    
            if ((target >= 1) && (target <= 9))
                return target;
            else if ((target >= 10) && (target <= 99))
                return ((target / 10) * (target % 10));
            else // 100 ~ 199
                return 1 * ((target / 10) % 10) * (target % 10);
        }
    
        int smallestNumber(int n, int t) {
            int output = n;
    
            while (output)
            {
                if (getProductDigit(output) % t == 0)
                    return output;
                output++;
            }
            
            return output;
        }
    };