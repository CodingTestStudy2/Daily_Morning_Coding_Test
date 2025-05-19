class Solution {
public:
    int surfaceArea(vector<vector<int>>& grid) {
        int output = 0;
        int dy[4] = {1, 0, -1, 0};
        int dx[4] = {0, 1, 0, -1};
        int nSize = grid.size();

        for (int i = 0; i < nSize; i++)
        {
            for (int j = 0; j < nSize; j++)
            {
                for (int m = 1; m <= grid[i][j]; m++)
                {
                    int adj = 0;
                    for (int u = 0; u < 4; u++)
                    {
                        int tmpY = i + dy[u];
                        int tmpX = j + dx[u];
                        if (tmpY < 0 || tmpY >= nSize || tmpX < 0 || tmpX >= nSize)
                            continue;
                        if (grid[tmpY][tmpX] >= m) // 1d adj
                            adj++;
                    }
                    if (grid[i][j] > 1)
                    {
                        if (m == 1 || m == grid[i][j])
                            adj++;
                        else if (m != 1 && m != grid[i][j])
                            adj += 2;
                    }
                    output += 6 - adj;
                }
            }
        }
        return output;
    }
};