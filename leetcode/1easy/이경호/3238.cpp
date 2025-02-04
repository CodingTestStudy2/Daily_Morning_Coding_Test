class Solution {
public:
  int winningPlayerCount(int n, vector<vector<int>>& picks) {
    map<int, map<int, int>> pickMap;
    for (vector<int> pick : picks) {
      pickMap[pick[0]][pick[1]] += 1;
    }
    int count = 0;
    for (auto& [pickKey, colorMap] : pickMap) {
      for (auto& [colorKey, colorNum] : colorMap) {
        if (colorNum > pickKey) {
          count++;
          break;
        }
      }
    }
    return count;
  }
};