class Solution {
    public:
        vector<int> mostVisited(int n, vector<int>& rounds) {
            vector<int> topVisited(n+1, 0);
            vector<int> output;
            int top = 0;
    
            for (int i = 0; i < rounds.size()- 1; i++)
            {
                int cur = rounds[i];
                while (cur != rounds[i+1])
                {
                    topVisited[cur]++;
                    cur++;
                    if (cur == n + 1)
                        cur = 1;
                }
            }
    
            topVisited[rounds.back()]++;
    
            for (int j = 1; j <= n; j++)
            {
                if (top < topVisited[j])
                {
                    output.clear();
                    top = topVisited[j];
                    output.push_back(j);
                }
                else if (top == topVisited[j])
                {
                    output.push_back(j);
                }
            }
            return output;
        }
    };