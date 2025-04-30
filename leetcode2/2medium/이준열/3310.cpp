class Solution {
    public:
        unordered_set<int> sus;
        map<int, vector<int> > graph;
        map<int, vector<int> > reverseGraph;
        
        void dfs(int target)
        {
            if (sus.count(target)) return;
            sus.insert(target);
            for (int n: graph[target]) dfs(n);
        }
    
        vector<int> remainingMethods(int n, int k, vector<vector<int>>& invocations) {
    
            for (vector<int> v: invocations)
            {
                graph[v[0]].push_back(v[1]);
                reverseGraph[v[1]].push_back(v[0]);
            }
    
            dfs(k);
    
            for (int i : sus)
            {
                for (int rev: reverseGraph[i])
                {
                    if (!sus.count(rev))
                    {
                        vector<int> all(n);
                        iota(all.begin(), all.end(), 0);
                        return all;
                    }
                }
            }
    
            vector<int> output;
            for (int j = 0; j < n; j++)
            {
                if (!sus.count(j)) output.push_back(j);
            }
            return output;     
        }
    };