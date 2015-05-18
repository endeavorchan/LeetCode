class Solution {
public:
    std::map<char, int> Hashtb;
    int lengthOfLongestSubstring(string s) {
        int begin = 0;
        int maxsubstrlen = 0;
        for(int i = 0; i < s.length(); ++i){
            if(Hashtb.count(s[i]) == 0 || Hashtb[s[i]] < begin){
                Hashtb[s[i]] = i;
                if(i - begin + 1 > maxsubstrlen){
                    maxsubstrlen = i-begin+1;
                }
            }
            else{
                int repeatidx = Hashtb[s[i]];
                Hashtb[s[i]] = i;
                begin = repeatidx + 1;
              //  int maybemax = i - repeatidx;
               // if(maybemax > maxsubstrlen)
                //  maxsubstrlen = maybemax;
            }
        }
        return maxsubstrlen;
    }
};