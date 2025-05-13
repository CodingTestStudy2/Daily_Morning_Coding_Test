class Solution {
    public:
        int maxScore(vector<int>& nums) {
            vector<long long> prefixSum(nums.size());
    
            sort(nums.begin(), nums.end(), std::greater<long long>());
            prefixSum[0] =nums[0];
    
            for ( long long i = 1; i < nums.size(); i++)
            {
                prefixSum[i] = nums[i] + prefixSum[i-1];
            }
    
            long long count = 0;
    
            for (long long prefix : prefixSum)
            {
                if (prefix > 0)
                    count++;
                else
                    break;
            }
    
            return count;
        }
    };