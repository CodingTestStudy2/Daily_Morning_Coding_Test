/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 * public:
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     int f(int x, int y);
 * };
 */

 class Solution {
    public:
        vector<vector<int>> findSolution(CustomFunction& customfunction, int z) {
            vector< vector<int> > output;
            int avail[1002][1002] = {0, }; // 0: tbd, 1: avail, 2: not possible
    
            for (int i = 1; i <= 1000; i++)
            {
                for (int j = 1; j <= 1000; j++)
                {
                    if (avail[i][j] == 0
                        && customfunction.f(i, j) == z)
                    {
                        avail[i][j] = 1;
                        avail[i+1][j] = 2;
                        avail[i][j+1] = 2;
                    }
                }
            }
    
            for (int i = 1; i <= 1000; i++)
            {
                for (int j = 1; j <= 1000; j++)
                {
                    if (avail[i][j] == 1)
                    {
                        std::vector<int> tmp(2);
                        tmp[0] = i;
                        tmp[1] = j;
                        output.push_back(tmp);
                    }
                }
            }
    
            return output;
        }
    };