#include <iostream>
#include <set>
#include <vector>
using namespace std;
class Solution {
    set<char> dict1[9];  // for col
    set<char> dict2[9];   // for row
    set<char> dict3[3][3];
    bool find;
public:
 
    void p(vector<vector<char>>& board ) {
         cout << endl;
         for (int i = 0; i < 9; ++i) {
	    for(int j = 0; j < 9; ++j) {
	        cout << board[i][j] << " ";
	    }
            cout << endl;
	 } 
	 cout << endl;
    }

    void initdict(vector<vector<char>>& board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    dict1[i].insert(board[i][j]);
                    dict2[j].insert(board[i][j]);
                    dict3[i/3][j/3].insert(board[i][j]);
                }
            }
        }
    }

    bool canput(char start, int i, int j, vector<vector<char>>& board) {
        if (dict1[i].find(start) != dict1[i].end()) {
            return false;
        } 
        
        if (dict2[j].find(start) != dict2[j].end()) {
            return false;
        } 
        
        if (dict3[i/3][j/3].find(start) != dict3[i/3][j/3].end()) {
            return false;
        } 
        
        dict1[i].insert(start);
        dict2[j].insert(start);
        dict3[i/3][j/3].insert(start);
        return true;
        
    }

    void erasefromdict(vector<vector<char>>& board, int i, int j, char s) {
        dict1[i].erase(s);
        dict2[j].erase(s);
        dict3[i/3][j/3].erase(s);
    }

    void solveSudoku(vector<vector<char>>& board, int i, int j) {
	
      //  bool tag = false;
        if (board[i][j] == '.') {
           // tag = true;
            char start = '1';
            for (; start <= '9'; ++start) {
                if (canput(start, i, j, board)) {
                    board[i][j] = start; // put
                    p(board);
                    if (i != 8 && j == 8) {
                        solveSudoku(board, i+1, 0);
                        if (find == true) {
                            return;
                        }
                 // backtracking
                        board[i][j] = '.';
                        erasefromdict(board, i, j, start);
                    
                    } else if (i == 8 && j == 8) {
                        find = true;
			p(board);
                        return;
            
                    } else {
                        solveSudoku(board, i, j+1);
                        if (find == true) {
                            return;
                        }
                    // backtracking
                        board[i][j] = '.';
                        erasefromdict(board, i, j, start);
                    
                    }
                }
                
            }
           // }
        } else {
            if (i != 8 && j == 8) {
                solveSudoku(board, i+1, 0);

            } else if (i == 8 && j == 8) {
                find = true;
                return;

            } else {
                solveSudoku(board, i, j+1);
            }
            
            if (find == true) {
                return;
            }
        }
        
        
    }

    void solveSudoku(vector<vector<char>>& board) {
        find = false;
        initdict(board);
        solveSudoku(board, 0, 0);
    }
};


int main() {
    vector<vector<char> > board;
    
   // ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]

    char m0[] = {'.','.','9','7','4','8','.','.','.'};
    vector<char> v0 (m0, m0 + sizeof(m0) / sizeof(char) );
    char m1[] = {'7','.','.','.','.','.','.','.','.'};
    vector<char> v1 (m1, m1 + sizeof(m1) / sizeof(char) );
    char m2[] = {'.','2','.','1','.','9','.','.','.'};
    vector<char> v2 (m2, m2 + sizeof(m2) / sizeof(char) );
    char m3[] = {'.','.','7','.','.','.','2','4','.'};
    vector<char> v3 (m3, m3 + sizeof(m3) / sizeof(char) );
    char m4[] = {'.','6','4','.','1','.','5','9','.'};
    vector<char> v4 (m4, m4 + sizeof(m4) / sizeof(char) );
    char m5[] = {'.','9','8','.','.','.','3','.','.'};
    vector<char> v5 (m5, m5 + sizeof(m5) / sizeof(char) );
    char m6[] = {'.','.','.','8','.','3','.','2','.'};
    vector<char> v6 (m6, m6 + sizeof(m6) / sizeof(char) );
    char m7[] = {'.','.','.','.','.','.','.','.','6'};
    vector<char> v7 (m7, m7 + sizeof(m7) / sizeof(char) );
    char m8[] = {'.','.','.','2','7','5','9','.','.'};
    vector<char> v8 (m8, m8 + sizeof(m8) / sizeof(char) );
   
   board.push_back(v0);
    board.push_back(v1);
    board.push_back(v2);
    board.push_back(v3);
    board.push_back(v4);
    board.push_back(v5);
    board.push_back(v6);
    board.push_back(v7);
    board.push_back(v8);
   

   Solution s;
   s.solveSudoku(board);
   
   cout << "******" << endl;
   for (int i = 0; i < 9; ++i) {
       for(int j = 0; j < 9; ++j) {
           cout << board[i][j] << " ";
       }
       cout << endl;
   }

   return 0;



 

}

