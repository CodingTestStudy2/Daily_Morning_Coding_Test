class Solution {
public:
  int minOperations(vector<int>& nums, int k) {
    unordered_set<int> targets;
    for (int i = 1; i <= k; i++) {
      targets.insert(i);
    }
    int ans = 0;
    int i = nums.size() - 1;
    while (targets.size()) {
      targets.erase(nums[i]);
      ans++;
      i--;
    }
    return ans;
  }
};