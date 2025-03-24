#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    long long maximumTripletValue(vector<int>& nums) {
        long long maxVal = 0;
        size_t len = nums.size();

        for (int i = 0; i < len - 2; i++)
        {
            for (int j = i + 1; j < len - 1; j ++)
            {
                long long gap = nums[i] - nums[j];
                if (gap < 0)
                    continue;
                for (int k = j + 1; k < len; k++)
                {
                    long long cur = gap * nums[k];
                    maxVal = std::max(maxVal, cur);
                }
            }
        }
    
        return maxVal;
    }
};