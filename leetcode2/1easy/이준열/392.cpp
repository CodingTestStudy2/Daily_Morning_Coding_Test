class Solution {
public:
    bool isSubsequence(string s, string t) {
        int curIndex = 0;
        for (int i = 0; i < t.size(); i++)
        {
            if (t[i] == s[curIndex])
            {
                curIndex++;
            }
        }



        if (curIndex == s.size())
            return true;
        else
            return false;
    }
};