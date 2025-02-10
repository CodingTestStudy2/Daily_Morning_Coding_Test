class Solution {
public:
  bool isSubsequence(string s, string t) {
    for (char c : s) {
      int findPos = t.find(c);
      if (findPos != string::npos) {
        t = string(t.begin() + findPos + 1, t.end());
      }
      else {
        return false;
      }
    }
    return true;
  }
};