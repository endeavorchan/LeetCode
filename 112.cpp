/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void getval(TreeNode *root, int sum, int &tag){
        if(root && root->right == NULL && root->left == NULL){
            if(sum-root->val == 0)
                tag = 1;
        }
        else if(root){
            sum = sum - root->val;
            getval(root->left, sum, tag);
            getval(root->right, sum, tag);
        }
        
    }
    
    bool hasPathSum(TreeNode *root, int sum) {
        if(root == NULL){
            return false;
        }
        if(root->val == sum)
            return false;
        if(root->left && hasPathSum(root->left, sum-root->val) || root->right && hasPathSum(root->right, sum-root->val))
            return true;
        return false;
        
    }
};