/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
 class Solution {
    public:
        bool isCousins(TreeNode* root, int x, int y) {
            deque<tuple<int, int, int>> dq; // val, depth, parent
            deque<TreeNode*> treeDq;
            pair<int, int> depthX = make_pair(-1, -1); // depth, parent
            pair<int, int> depthY = make_pair(-1, -1);
            dq.push_back(make_tuple(root->val, 0, -1));
            treeDq.push_back(root);
    
            while (!treeDq.empty())
            {
                auto top = treeDq.back();
                auto topVal = dq.back();
    
                if (get<0>(topVal) == x)
                {
                    depthX = make_pair(get<1>(topVal), get<2>(topVal));
                }
                if (get<0>(topVal) == y)
                {
                    depthY = make_pair(get<1>(topVal), get<2>(topVal));
                }
    
                treeDq.pop_back();
                dq.pop_back();
                if (top->left)
                {
                    treeDq.push_back(top->left);
                    dq.push_back( make_tuple(top->left->val, get<1>(topVal) + 1, get<0>(topVal) ));
                }
                if (top->right)
                {
                    treeDq.push_back(top->right);
                    dq.push_back(make_tuple(top->right->val, get<1>(topVal) + 1, get<0>(topVal) ));
                }
            }
    
            if (depthX.first == -1 || depthY.first == -1)
                return false;
            return (depthX.first == depthY.first) && (depthX.second != depthY.second);
        }
    };