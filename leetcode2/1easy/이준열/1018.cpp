class Solution {
    public:
        vector<bool> prefixesDivBy5(vector<int>& nums) {
            vector<long long> convertedPrefixSum(nums.size());
            vector<bool> output(nums.size());
            convertedPrefixSum[0] = nums[0];
            
            for (int i = 1; i < nums.size(); i++)
            {
                long long num = (convertedPrefixSum[i-1] * 2) % 5 + nums[i];
                convertedPrefixSum[i] = num;
            }
    
            for (int j = 0; j < convertedPrefixSum.size(); j++)
            {
                if (convertedPrefixSum[j] % 5 == 0)
                    output[j] = true;
                else
                    output[j] = false;
            }
            return output;
        }
    };