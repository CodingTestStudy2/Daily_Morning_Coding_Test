class Solution {
    public:
        int numberOfChild(int n, int k) {
            int dir = 1;
            int cur  = 0;
            
            for (int i = 0; i < k; i++)
            {
                if ((i != 0)
                    && ((cur == 0) || (cur == n-1)))
                    dir *= -1;
                cur += dir;
            }
    
            return cur;
        }
    };