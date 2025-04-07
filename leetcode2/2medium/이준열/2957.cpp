class Solution {
    public:
        bool isAlmostequal(char prev, char cur)
        {
            if ((prev == cur)
                || (prev - 1 == cur)
                || (prev + 1 == cur))
                return true;
            else
                return false; 
        }
    
    
        int removeAlmostEqualCharacters(string word) {
            int output = 0;
    
            char prev = 0;
            int equalCnt = 0;
    
            for (char c: word)
            {
                if ((prev == 0)
                    || (isAlmostequal(prev, c)))
                {
                    equalCnt++;
                }
                else
                {
                    if (equalCnt != 1)
                        output += (equalCnt / 2);
                    equalCnt = 1;
                }
                prev = c;
            }
    
            if (equalCnt != 0)
                output += (equalCnt / 2);
    
            return output;
        }
    };