class Solution {
    public:
        int countPartitions(vector<int>& nums) {
            vector<int> prefixSum(nums.size());
            prefixSum[0] = nums[0];
            int output = 0;
    
            for (int i = 1; i < nums.size(); i++)
            {
                prefixSum[i] = nums[i] + prefixSum[i-1];
            }
    
            for (int j = 0; j < prefixSum.size() - 1; j++)
            {
                if ((2 * prefixSum[j] - prefixSum.back()) % 2 == 0)
                    output++;
            }
            return output;
        }
    };