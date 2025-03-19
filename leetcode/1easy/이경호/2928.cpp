class Solution {
  public:
      int distributeCandies(int n, int limit) {
          int ans = 0;
          for(int i = 0; i <= n; i++) {
              if(i > limit) {
                  continue;
              }
              for(int j = 0; j <= n - i; j++) {
                  if(j > limit || n - i - j > limit) {
                      continue;
                  }
                  ans++;
              }
          }
          return ans;
      }
  };