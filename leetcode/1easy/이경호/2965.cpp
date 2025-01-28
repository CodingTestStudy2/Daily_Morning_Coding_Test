class Solution {
public:
  vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
    vector<int> answer(2);
    map<int, int> appearance;
    for (vector<int> column : grid) {
      for (int cell : column) {
        if (appearance.find(cell) == appearance.end()) {
          appearance.insert({ cell, 0 });
        }
        else {
          appearance[cell]++;
        }
      }
    }
    for (int i = 1; i <= grid.size() * grid.size(); i++) {
      if (appearance.find(i) == appearance.end()) {
        answer[1] = i;
      }
      else {
        if (appearance[i] == 1) {
          answer[0] = i;
        }
      }
    }
    return answer;
  }
};