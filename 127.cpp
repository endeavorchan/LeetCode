/* remember to use reference to accerate (without using reference the program may exceed run time) */
class Solution {
public:
    enum Type{SAME, MOREST, ONEST}; 
    Type onestep(const string &s,const string &t, int len){  // const string &
        // of the same length
        if(s == t){
            return SAME;
        }
       // int len = s.length();
        int num = 0;
        for(int i = 0; i < len; ++i){
            if(s[i] != t[i]){
                num++;
                if(num > 1)
                    return MOREST; // MOREST
            }
        }
        return ONEST; // ONEST
    }
    int ladderLength(string &start, string &end, unordered_set<string> &dict) {
        if(start == end)
            return 1;
        map<string, bool> wordmap;
        int wlen = start.length();
        unordered_set<string> dict1 = dict;
        /*
        typedef struct {
            string word;
            int level;
        } Ele;
        Ele e {a, b};  // can do
        */
        int level = 1;
        int nextnum = 0;
        int curnum = 1;
        queue<string> bsfque;
        bsfque.push(start);

        while(!bsfque.empty()){

            string front = bsfque.front();
   
            unordered_set<string>::iterator iter = dict1.begin();
            while(iter != dict1.end()) {
                    if(onestep(front, *iter, wlen) == ONEST){
                        if(*iter == end){
                            return  level+1;
                        }
                        bsfque.push(*iter);
                        iter = dict1.erase(iter);
                        nextnum++;
                    }
                    else
                        iter++;
            }
            bsfque.pop();
            curnum--;
            if(curnum == 0){
                curnum = nextnum;
                nextnum = 0;
                level++;
            }
        }
        return 0;
    }
};