class Solution {
    public:
        vector<int> zigzagTraversal(vector<vector<int>>& grid) {
            vector<int> output;
    
            int i , j;
            for (i = 0; i < grid.size();)
            {
    
                if (i % 2 == 0) // right dir pattern-0
                {
                    for (j = 0; j < grid[0].size();)
                    {
                        output.push_back(grid[i][j]);
                        j += 2;
                    }
                }
                else // left dir
                {
                    if (grid[0].size() % 2 == 0)
                        j = grid[0].size() - 1;
                    else
                        j = grid[0].size() - 2;
    
                    for (; j >= 0;)
                    {
                        output.push_back(grid[i][j]);
                        j -= 2;
                    }
                }
                i++;
            }
    
            return output;
        }
    };