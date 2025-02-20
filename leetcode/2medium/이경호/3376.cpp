class Solution {
public:
  int findMinimumTime(vector<int>& strengths, int k) {
    int ans = 10000000;
    sort(strengths.begin(), strengths.end());
    do {
      int t = 0;
      int x = 1;
      for (int strength : strengths) {
        t += strength / x;
        if (strength % x) {
          t++;
        }
        x += k;
      }
      ans = std::min(ans, t);
    } while (next_permutation(strengths.begin(), strengths.end()));
    return ans;
  }
};