class Solution {
public:
    void inorder(TreeNode* root, int x, vector<int> &temp, vector<vector<int>> &ans) {
        if(!root) return;
        if(!root->left && !root->right) {
            if(x == root->val) {
                temp.push_back(root->val);
                ans.push_back(temp);
                temp.pop_back();
            }
            return;
        }
        temp.push_back(root->val);
        inorder(root->left, x-root->val, temp, ans);
        temp.pop_back();
        temp.push_back(root->val);
        inorder(root->right, x-root->val, temp, ans);
        temp.pop_back();
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> ans;
        vector<int> temp;
        inorder(root, targetSum, temp, ans);
        return ans;
    }
};