class Solution {
public:
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};

    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        int output = 0;
        vector<vector<int>> mineMap(n, vector<int>(n,n));

        for (vector<int> m : mines)
        {
            mineMap[m[0]][m[1]] = 0;
        }

        for (int j = 0; j < n; j++)
        {
            int count = 0;
            for (int i = 0; i < n; i++)
            {
                count = (mineMap[i][j] == 0) ? 0 : count + 1;
                mineMap[i][j] = min(mineMap[i][j], count);
            }

            count = 0;
            for (int i = n-1; i >= 0; i--)
            {
                count = (mineMap[i][j] == 0) ? 0 : count + 1;
                mineMap[i][j] = min(mineMap[i][j], count);
            }
        }



        for (int i = n-1; i >= 0; i--)
        {
            int count = 0;
            for (int j = 0; j < n; j++)
            {
                count = (mineMap[i][j] == 0) ? 0 : count + 1;
                mineMap[i][j] = min(mineMap[i][j], count);
            }

            count = 0;
            for (int j = n-1; j >= 0; j--)
            {
                count = (mineMap[i][j] == 0) ? 0 : count + 1;
                mineMap[i][j] = min(mineMap[i][j], count);
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                output = max(output, mineMap[i][j]);
            }
        }

        return output;
        
    }
};