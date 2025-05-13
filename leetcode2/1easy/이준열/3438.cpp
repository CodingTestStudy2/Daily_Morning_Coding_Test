class Solution {
    public:
        string findValidPair(string s) {
            int adj[10] = {0, };
            int cnt = 0;
            string numStr = "0123456789";
            string output = "";
            string uniqueSet = "";
            for (int i = 0; i < s.size(); i++)
            {
                int tmp = static_cast<int>(s[i] - '0');
                adj[tmp]++;
            }
    
            for (int j = 0; j < s.size() - 1; j++)
            {
                char former = s[j];
                char latter = s[j+1];
    
                int formerTmp = static_cast<int>(former - '0');
                int latterTmp = static_cast<int>(latter - '0');
    
                if (former != latter)
                {
                    if ((adj[formerTmp] == formerTmp) && (adj[latterTmp] == latterTmp))
                    {
                        output += former;
                        output += latter;
                        return output;
                    }
                }
            }
    
            return "";
        }
    };