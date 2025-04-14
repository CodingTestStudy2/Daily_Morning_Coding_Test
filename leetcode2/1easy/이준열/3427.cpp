class Solution {
    public:
        int subarraySum(vector<int>& nums) {
            int output = 0;
    
            for (int i = 0; i < nums.size(); i++)
            {
                int tmp = 0;
                for (int j = max(0, i - nums[i]); j <= i; j++)
                {
                    tmp += nums[j];
                }
                output += tmp;
            }
    
    
            return output;
            
        }
    };