class Solution {
    public:
        int equalSubstring(string s, string t, int maxCost) {
            vector<int> costs(s.size(), 0);
            vector<int> longestSub(s.size(), 0);
            int cost = 0;
            int backPoint = 0;
            int streak = 0;
            int maxStreak = 0;
    
            for (int i = 0; i < s.size(); i++)
            {
                costs[i] = abs((int)s[i] - (int)t[i]);
            }
    
            for (int j = 0; j < costs.size(); j++)
            {
                cost += costs[j];
    
                if (cost <= maxCost)
                {
                    streak++;
                }
                else
                {
                    maxStreak = max(maxStreak, streak);
                    while (cost > maxCost)
                    {
                        cost -= costs[backPoint++];
                        streak--;
                    }
                    streak++;
                }
            }
            maxStreak = max(maxStreak, streak);
            return maxStreak;
            
        }
    };