class Solution {
public:
    vector<vector<int>> sortMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        //bottom-left
        for (int i = n - 1; i >= 0; i--)
        {
            // [i,0] -> [n - 1, ~]
            vector<int> diagonal;
            int x = i, y = 0;

            while (x < n && y < n)
            {
                diagonal.push_back(grid[x][y]);
                x++; y++;
            }

            sort(diagonal.begin(), diagonal.end(), greater<int>());

            x = i; y = 0;
            int idx = 0;
            while (x < n && y < n)
            {
                grid[x][y] = diagonal[idx++];
                x++; y++;
            }
        }

        // top-right
        for (int i = 1; i <= n -1; i++)
        {
            // [0, i] -> [~, n-1]
            vector<int> diagonal;
            int x = 0, y = i;

            while (x < n && y < n)
            {
                diagonal.push_back(grid[x][y]);
                x++; y++;
            }

            sort(diagonal.begin(), diagonal.end());

            x = 0; y = i;
            int idx = 0;
            while (x < n && y < n)
            {
                grid[x][y] = diagonal[idx++];
                x++; y++;
            }
        }

        return grid;
    }
};