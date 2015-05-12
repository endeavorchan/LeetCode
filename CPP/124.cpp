/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxPathSum(TreeNode* root) {
        int temp = INT_MIN;
        maxPathSum1(root, temp);
        return temp;
    }

    int getmax(int sa,int  s0,int  sl, int sr) {
        int a = max(sa, s0);
        int b = max(sl, sr);
        return max(a, b);
    }
    
    int getmax1(int s0, int sl, int sr) {
        int a = max(s0, sl);
        return max(a, sr);
    }

    int maxPathSum1(TreeNode* root, int &temp) {
        int leftsum = 0;
        int rightsum = 0;
        if (!root) {
            return 0;
        }
        leftsum = maxPathSum1(root->left, temp);
        rightsum = maxPathSum1(root->right, temp);
        int sa = leftsum + root->val + rightsum;
        int s0 = root->val;
        int sl = leftsum + root->val;
        int sr = rightsum + root->val;
        int all = getmax(sa, s0, sl, sr);
        if (all > temp) {
            temp = all;
        }
        return getmax1(s0, sl, sr);
    }  
    
};