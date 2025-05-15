class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> indegree(numCourses);
        vector<vector<int>> edges(numCourses);


        for (vector<int> p: prerequisites)
        {
            edges[p[1]].push_back(p[0]);
            indegree[p[0]]++;
        }

        queue<int> q;
        for (int i = 0; i < numCourses; i++)
        {
            if (indegree[i] == 0)
                q.push(i);
        }

        vector<int> topologicalSorted;
        while (!q.empty())
        {
            int tmp = q.front(); q.pop();
            topologicalSorted.push_back(tmp);

            for (int n: edges[tmp])
            {
                if (--indegree[n] == 0)
                    q.push(n);
            }
        }

        if (topologicalSorted.size() == numCourses)
            return true;
        else
            return false;
    }
};