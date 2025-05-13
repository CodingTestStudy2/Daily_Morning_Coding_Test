class Solution {
    public:
        int maxDistToClosest(vector<int>& seats) {
            pair<int, int>current = {0,0};
            int maxDistance = -1;
            for (int i = 0 ; i < seats.size(); i++)
            {
                if (seats[i] == 0)
                {
                    if (current.second == -1)
                    {
                        current.first = i;
                        current.second = 0;
                    }
                    current.second++;
                }
                else
                {
                    // case handling: vacant seat at last and first
                    if (current.first == 0)
                        maxDistance = max(maxDistance, current.second);
                    else
                        maxDistance = max(maxDistance, (current.second + 1) / 2);
                    current = {i+1, -1};
                }
            }
            if (current.second > 0)
                maxDistance = max(maxDistance, current.second);
    
            return maxDistance;
    
            
        }
    };