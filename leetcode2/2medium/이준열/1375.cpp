class Solution {
    public:
        int numTimesAllBlue(vector<int>& flips) {
            int output = 0;
            int i = 0;
            vector<bool> used(flips.size(), false);
            set<int> s;
    
            for (;i < flips.size(); i++)
            {
                if (used[i] == false)
                {
                    s.insert(i);
                }
    
                used[flips[i] - 1] = true;
                auto it = s.find(flips[i] -1);
                if (it != s.end())
                    s.erase(it);
    
                if (s.empty())
                    output++;
            }
            return output;
        }
    };