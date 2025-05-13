class Solution {
    public:
        int countBinarySubstrings(string s) {
            char currentColor = s[0];
            int output = 0;
            int count = 1;
            vector<int> adjDigits;
    
            for (int i = 1; i < s.size(); i++)
            {
                if (s[i] == currentColor)
                {
                    count++;
                }
                else
                {
                    adjDigits.push_back(count);
                    count = 1;
                    currentColor = s[i];
                }
            }
            if (count != 0)
                adjDigits.push_back(count);
            
            if (adjDigits.size() == 1)
                return 0;
            
            for (int i = 1; i < adjDigits.size(); i++)
            {
                output += min(adjDigits[i], adjDigits[i-1]);
            }
            return output;
        }
    };