class Solution {
    public:
        map<int, vector< std::pair <int, int> >>columnSet;
        std::pair<int, int> left = {1, -1};
        std::pair<int, int> right = {1, 1};
    
        void checkNode(TreeNode *target, int x, int y)
        {
            if (target == nullptr)
                return;
    
            columnSet[y].push_back(make_pair(x, target->val));
    
            checkNode(target->left, x + left.first, y + left.second);
            checkNode(target->right, x + right.first, y + right.second);
        }
    
        bool customComp(pair<int, int> A, pair<int, int> B)
        {
            if (A.first < B.first)
            {
                return true;
            }   
            else if (A.first == B.first)
            {
                return A.second < B.second;
            }
            else
            {
                return false;
            }
        }
    
        vector<vector<int>> verticalTraversal(TreeNode* root) {
    
            vector<vector<int>> output;
    
            columnSet[0].push_back(make_pair(0, root->val));
            checkNode(root->left, 1, -1);
            checkNode(root->right, 1, 1);
    
            for (auto pair: columnSet)
            {
                vector<std::pair<int, int>> v = pair.second;
                vector<int> tmp(v.size());
                sort(v.begin(), v.end(), [](std::pair<int, int> A, std::pair<int, int> B)
                {
                    if (A.first < B.first)
                    {
                        return true;
                    }   
                    else if (A.first == B.first)
                    {
                        return A.second < B.second;
                    }
                    else
                    {
                        return false;
                    }
                });
                for (int i = 0; i < v.size(); i++)
                {
                    tmp[i] = v[i].second;
                }
                output.push_back(tmp);
            }
            return output;
        }
    };