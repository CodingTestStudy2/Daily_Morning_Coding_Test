class Solution {
    public:
        unordered_map<string, vector<int>> cache;
    
        vector<int> diffWaysToCompute(string expression) {
            if (cache.count(expression)) return cache[expression];
    
            vector<int> res;
            for (int i = 0; i < expression.size(); i++)
            {
                if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*')
                {
                    string left = expression.substr(0, i);
                    string right = expression.substr(i+1);
    
                    vector<int> leftVals = diffWaysToCompute(left);
                    vector<int> rightVals = diffWaysToCompute(right);
    
                    for (int l : leftVals)
                    {
                        for (int r: rightVals)
                        {
                            if (expression[i] == '+') res.push_back(l+r);
                            else if (expression[i] == '-') res.push_back(l-r);
                            else if (expression[i] == '*') res.push_back(l*r);
                        }
                    }
                }
            }
            if (res.empty()) res.push_back(stoi(expression));
    
            return cache[expression] = res;
        }
    };