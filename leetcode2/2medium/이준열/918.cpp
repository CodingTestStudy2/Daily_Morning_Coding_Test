#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        int len = nums.size();
        
        if (len == 1)
            return nums[0];

        int curMin = nums[0], curMax = nums[0];
        int minVal = nums[0], maxVal = nums[0];
        int totalSum = nums[0];
        for (int i = 1; i < len; i++)
        {
            totalSum += nums[i];
            curMin = std::min(curMin + nums[i], nums[i]);
            curMax = std::max(curMax + nums[i], nums[i]);

            minVal = std::min(curMin, minVal);
            maxVal = std::max(curMax, maxVal);
        }

        if (minVal == totalSum)
            return maxVal;

        return std::max(maxVal, totalSum - minVal);
    }
};

// class Solution {
// public:
//     int maxSubarraySumCircular(vector<int>& nums) {
//         int len = nums.size();
//         // i = first index
//         int maxVal = nums[0];
//         for (int i= 0; i < len; i++)
//         {
//             int cnt = 0;
//             int curSum = 0;
//             while (cnt < len)
//             {
//                 curSum += nums[(i + cnt) % len];
//                 maxVal = std::max(maxVal, curSum);
//                 cnt++;
//             }
//         }
//         return maxVal;
//     }
// };