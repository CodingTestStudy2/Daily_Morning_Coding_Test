class Solution {
public:
  int alternatingSubarray(vector<int>& nums) {
    int start = 0;
    int end = 1;
    int ans = -1;
    int cnt = 1;
    while (true) {
      if (end == nums.size()) {
        ans = std::max(ans, cnt);
        return ans > 1 ? ans : -1;
      }
      if ((nums[end] - nums[end - 1]) == (((end - start) % 2) ? 1 : -1)) {
        cnt++;
        end++;
        continue;
      }
      else {
        ans = std::max(ans, cnt);
        cnt = 1;
        if ((end - start) % 2) {
          start = end;
          end++;
          continue;
        }
        else {
          start = end - 1;
          continue;
        }
      }
    }
  }
};