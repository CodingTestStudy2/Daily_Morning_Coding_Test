class Solution {
  public:
      int numberOfAlternatingGroups(vector<int>& colors, int k) {
          colors.insert(colors.end(), colors.begin(), colors.end());
          int ans = 0;
          int size = 1;
          int color = colors[0];
          for(int i = 1 ; i < colors.size() / 2 + k - 1; i++) {
              if(colors[i] != color) {
                  size++;
                  if(size >= k) {
                      ans++;
                  }
              }
              else {
                  size = 1;
              }
              color = colors[i];
          }
          return ans;
      }
  };