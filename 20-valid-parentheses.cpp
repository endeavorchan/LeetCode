#include <string>
#include <iostream>
#include <stack>
using namespace std;
using std::stack;
using std::string;
class Solution {
    public:
            bool isValid(string s) {
                int size = s.length();
                if(size == 0) return true;
                stack<char> stk;
                int index=0;
                while(index < size){
                    if(s[index] == '(' ||
                            s[index] == '{' ||
                            s[index] == '['){
                        stk.push(s[index++]);
                        continue;
                    }
                    if(stk.empty()) return false;
                    else if( (s[index] == ')') && (stk.top() != '(')) return false; 
                    else if( (s[index] == '}') && (stk.top() != '{')) return false;
                    else if( (s[index] == ']') && (stk.top() != '[')) return false;
                    
                    stk.pop();
                    index++;
                }
                if(index == size&& stk.size()==0) return true;
                return false;
                        
            }
};
int main(){
        Solution slv;
        if(slv.isValid("()()[({})]")) cout << "valid" << endl;
        else cout << "not valid" << endl;
        if(slv.isValid("]")) cout << "valid" << endl;
                else cout << "not valid" << endl;
        cout << "test end" << endl;
        return 0;
}

