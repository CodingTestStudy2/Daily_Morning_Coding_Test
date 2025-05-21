class Solution {
public:
    string removeOuterParentheses(string s) {
        string output = "";
        string tmp = "";
        int left = 0;
        int right = 0;
        int chunk = 0;

        for (int i = 0; i < s.size(); i++)
        {
            if ((left == right) && (left != 0 && right != 0))
            {
                if (chunk > 2)
                    output += tmp.substr(1, chunk - 2);
                tmp = "";
                chunk = 0, left = 0, right = 0;
            }
            if (s[i] == '(')
                left++;
            else
                right++;
            chunk++;
            tmp += s[i];
        }
        if ((left == right) && (left != 0 && right != 0))
        {
            if (chunk > 2)
                output += tmp.substr(1, chunk - 2);
            tmp = "";
            chunk = 0, left = 0, right = 0;
        }
        return output;
    }
};