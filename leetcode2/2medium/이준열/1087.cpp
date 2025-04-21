class Solution {
    public:
        string evaluate(string s, vector<vector<string>>& knowledge) {
            unordered_map<string, string> macroSet;
            string output;
    
            for (vector<string> v: knowledge)
            {
                macroSet[v[0]] = v[1];
            }
            
    
            for (int i = 0; i < s.size(); i++)
            {
                if (s[i] == '(')
                {
                    i++;
                    string sub;
                    while (s[i] != ')')
                    {
                        sub += s[i];
                        i++;
                    }
                    if (macroSet[sub] == "")
                        output += "?";
                    else
                        output += macroSet[sub];
                }
                else
                {
                    output += s[i];
                }
            }
    
            return output;
        }
    };