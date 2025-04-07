class Solution {
    public:
        int possibleStringCount(string word) {
            int output = 0;
            char prev = 0;
            int dupCnt = 0;
    
            for (char c: word)
            {
                if (prev == 0
                    || prev == c)
                {
                    dupCnt++;
                }
                else
                {
                    if (dupCnt != 1)
                    {
                        if (output == 0)
                            output += dupCnt;
                        else
                            output += dupCnt - 1;
                    }
                    dupCnt = 1;
                }
                prev = c;
            }
    
            if (dupCnt != 1)
            {
                if (output == 0)
                    output += dupCnt;
                else
                    output += dupCnt - 1;
            }
    
            if (output == 0)
                return 1;
            else
                return output;
        }
    };