class Solution {
    public:
        bool IsInRange(int x1, int y1, int x2, int y2, int dist)
        {
            long long longDist = static_cast<long long>(dist);
    
            long long distX = longDist * longDist;
    
            long long dx  = static_cast<long long>(x2 - x1);
            long long dy = static_cast<long long>(y2 - y1);
    
    
            long long value = dx * dx + dy * dy;
    
            return distX >= value;
        }
    
        int maximumDetonation(vector<vector<int>>& bombs) {
            int output = 0;
            vector<int> maxExplosion(bombs.size());
    
            for (int i = 0; i < bombs.size(); i++)
            {
                vector<bool> bombExploded(bombs.size(), false);
                deque<int> dq;
                dq.push_back(i);
                bombExploded[i] = true;
                maxExplosion[i]++;
    
                while (!dq.empty())
                {
                    int top = dq.back();
                    pair<int, int> topLoc = make_pair(bombs[top][0], bombs[top][1]);
                    int radius = bombs[top][2];
    
                    dq.pop_back();
    
                    for (int j = 0; j < bombs.size(); j++)
                    {
                        if (IsInRange(topLoc.first, topLoc.second, bombs[j][0], bombs[j][1], radius)
                            && bombExploded[j] == false)
                        {
                            maxExplosion[i]++;
                            bombExploded[j] = true;
                            dq.push_back(j);
                        }
                    }
                }
            }
    
            for (int m : maxExplosion)
            {
                if (m > output)
                    output = m;
            }
            return output;
        }
    };