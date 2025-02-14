class Solution {
public:
  int count(int n) {
    int c = 0;
    while (n != 0) {
      if (n % 2 == 1) {
        c++;
      }
      n /= 2;
    }
    return c;
  }

  int sumIndicesWithKSetBits(vector<int>& nums, int k) {
    int sum = 0;
    for (int i = 0; i < nums.size(); i++) {
      if (count(i) == k) {
        sum += nums[i];
      }
    }
    return sum;
  }
};