class Solution {
public:
  int findChampion(vector<vector<int>>& grid) {
    for (int i = 0; i < grid.size(); i++) {
      int zc = 0;
      for (int j = 0; j < grid[i].size(); j++) {
        if (grid[i][j] == 0) {
          zc++;
        }
      }
      if (zc == 1) {
        return i;
      }
    }
    return -1;
  }
};