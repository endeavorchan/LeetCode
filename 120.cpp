class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
        int size = triangle.size();
        if(size == 1)
            return triangle[size-1][0];
        int i = 1;
      //  vector<int> temp;
        while(i < size){  //size = 2, i = 1
            //temp = triangle[i];
         //   for(int k = 0; k < triangle[i].size(); ++k){
       //         temp.push_back(triangle[i][k]);
       //     }
            int j = 0;
            while(j <= i){
                if(j == 0){
                    triangle[i][j] = triangle[i-1][j]+triangle[i][j];
                }
                else if(j == i){
                    triangle[i][j] = triangle[i-1][j-1]+triangle[i][j];
                }
                else{
                    int l = triangle[i-1][j-1]+triangle[i][j];
                    int r = triangle[i-1][j]+triangle[i][j];
                    //triangle[i][j] = l < r? l:r;
                    if(l<r)
                        triangle[i][j] = l;
                    else
                        triangle[i][j] = r;
                }
                ++j;
            }
            i++;
        }
        int min = INT_MAX;
        for(int i = 0; i < size; ++i){
            if(triangle[size-1][i] < min)
                min = triangle[size-1][i];
        }
        return min;
    }
};