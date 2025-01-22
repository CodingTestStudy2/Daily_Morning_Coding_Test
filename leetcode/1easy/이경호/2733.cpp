#include<algorithm>
#include<vector>

using namespace std;

class Solution {
public:
  int findNonMinOrMax(vector<int>& nums) {
    int maxElement = *max_element(nums.begin(), nums.end());
    int minElement = *min_element(nums.begin(), nums.end());
    for (int i = 0; i < nums.size(); i++) {
      if (nums[i] != maxElement && nums[i] != minElement) {
        return nums[i];
      }
    }
    return -1;
  }
};
