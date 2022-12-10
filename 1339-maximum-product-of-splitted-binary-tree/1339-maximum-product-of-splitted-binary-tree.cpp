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
    void util(TreeNode* root, long long &sum) {
        if(!root) return;
        sum += root->val;
        util(root->left, sum);
        util(root->right, sum);
    }
    long long func(TreeNode* root, long long &sum, long long &ans) {
        if(!root) return 0;
        long long temp = 0;
        temp = func(root->left, sum, ans);
        temp += func(root->right, sum, ans);
        temp += root->val;
        ans = max(ans, temp * (sum - temp));
        return temp;
    }
    int maxProduct(TreeNode* root) {
        long long ans = 0;
        long long sum = 0;
        long long temp = 0;
        long long m = 1e9+7;
        util(root, sum);
        func(root, sum, ans);
        return ans % m;
    }
};