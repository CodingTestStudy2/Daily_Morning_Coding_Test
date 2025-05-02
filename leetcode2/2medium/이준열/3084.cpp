class Solution {
    public:
        long long countSubstrings(string s, char c) {
            long long cnt = 0;
            for (char n: s)
            {
                if (n == c)
                    cnt++;
            }
    
            return cnt + (cnt * (cnt -1)) / 2; // just pick one or pick two(but separated)
        }
    };