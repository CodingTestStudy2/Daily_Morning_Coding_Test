class Solution {
public:
  bool makeEqual(vector<string>& words) {
    map<char, int> cMap;
    for (auto word : words) {
      for (char c : word) {
        cMap[c]++;
      }
    }
    for (auto& [key, value] : cMap) {
      if (value % words.size()) {
        return false;
      }
    }
    return true;
  }
};