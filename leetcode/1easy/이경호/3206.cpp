class Solution {
  public:
      int numberOfAlternatingGroups(vector<int>& colors) {
          int ans = 0;
          colors.insert(colors.end(), colors.begin(), colors.end());
          for(int i = 2; i < (colors.size() / 2) + 2; i++) {
              if(colors[i - 2] != colors[i - 1] && colors[i - 1] != colors[i]) {
                  ans++;
              }
          }
          return ans;
      }
  };