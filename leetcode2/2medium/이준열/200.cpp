class Solution {
public:
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};
    bool visited[300][300] = {};
    
    void bfs(vector<vector<char>>& grid, int y, int x)
    {
        queue<pair<int, int>> q;
        visited[y][x] = true;
        q.push(make_pair(y,x));

        while (!q.empty())
        {
            pair<int, int> p = q.front();
            q.pop();

            for (int i = 0; i < 4; i++)
            {
                int tmpY = p.first + dy[i];
                int tmpX = p.second + dx[i];
                if (tmpY < 0 || tmpY >= grid.size() || tmpX < 0 || tmpX >= grid[0].size())
                    continue;
                if (grid[tmpY][tmpX] == '1' && visited[tmpY][tmpX] == false)
                {
                    q.push(make_pair(tmpY, tmpX));
                    visited[tmpY][tmpX] = true;
                }
            }
        }
    }


    int numIslands(vector<vector<char>>& grid) {
        int output = 0;
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid[0].size(); j++)
            {
                if (grid[i][j] == '1' && visited[i][j] == false)
                {
                    output++;
                    bfs(grid, i, j);
                }
            }
        }
        return output;
    }
};