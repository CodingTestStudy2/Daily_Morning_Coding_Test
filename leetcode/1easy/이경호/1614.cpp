class Solution {
public:
  int maxDepth(string s) {
    int max = 0;
    int d = 0;
    for (char c : s) {
      if (c == '(') {
        d++;
        max = d > max ? d : max;
      }
      if (c == ')') {
        d--;
      }
    }
    return max;
  }
};