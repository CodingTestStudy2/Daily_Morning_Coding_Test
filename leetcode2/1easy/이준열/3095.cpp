class Solution {
    public:
        int minimumSubarrayLength(vector<int>& nums, int k) {
            int output = 51;
    
    
            for (int i = 0; i < nums.size(); i++)
            {
                int curIndex = i;
                int curSum = 0;
                int cnt = 1;
                for (;curIndex < nums.size(); curIndex++)
                {
                    curSum |= nums[curIndex];
                    if (curSum >= k)
                    {
                        output = min(cnt, output);
                        break;
                    }
                    else
                    {
                        cnt++;
                    }
                } 
            }
            return (output == 51) ? -1 : output;
            
        }
    };