class Solution {
  public:
      bool canMakeSquare(vector<vector<char>>& grid) {
          for(int i = 0; i < 2; i++) {
              for(int j = 0; j < 2; j++) {
                  int b = 0;
                  int w = 0;
                  for(int k = 0; k < 2; k++) {
                      for(int r = 0; r < 2; r++) {
                          if(grid[i + k][j + r] == 'B') {
                              b++;
                          }
                          else {
                              w++;
                          }
                      }
                  }
                  if(b >= 3 || w >= 3) {
                      return true;
                  }
              }
          }
          return false;
      }
  };