class Solution {
public:
  int maxRotateFunction(vector<int>& nums) {
    // F(0)
    int prev = 0;
    for (int i = 0; i < nums.size(); i++) {
      prev += i * nums[i];
    }
    // F(k(> 0))
    int max = prev;
    int numsSum = reduce(nums.begin(), nums.end(), 0);
    for (int k = 1; k < nums.size(); k++) {
      prev += numsSum;
      prev -= (nums.size()) * nums[nums.size() - k];
      max = std::max(max, prev);
    }
    return max;
  }
};