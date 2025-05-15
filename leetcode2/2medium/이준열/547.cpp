class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int output = 0;
        int nodeCnt = isConnected.size();
        vector<vector<int>> edges(nodeCnt);
        vector<bool> IsVisited(nodeCnt, false);

        for (int i = 0; i < nodeCnt; i++)
        {
            for (int j = 0; j < nodeCnt; j++)
            {
                if (i != j && isConnected[i][j] == 1)
                {
                    edges[i].push_back(j);
                }
            }
        }

        for (int i = 0; i < nodeCnt; i++)
        {
            if (IsVisited[i] == false)
            {
                output++;
                deque<int> dq;
                dq.push_back(i);
                IsVisited[i] = true;

                while (!dq.empty())
                {
                    int top = dq.back();
                    dq.pop_back();

                    for (int n : edges[top])
                    {
                        if (IsVisited[n] == false)
                        {
                            dq.push_back(n);
                            IsVisited[n] = true;
                        }
                    }
                }
            }
        }
        return output;
        
    }
};