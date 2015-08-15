package oneDistance;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        boolean oneDistance = false;
        boolean isSame = true;
        int i1 = 0;
        int i2 = 0;
        if (s == null || t == null)
            return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;
        boolean isSameLength = s.length() == t.length();
        while (i1 < s.length() && i2 < t.length()) {
            if (s.charAt(i1) == t.charAt(i2)) {
                i1++;
                i2++;
            } else {
                isSame = false;
                if (oneDistance) {
                    oneDistance = false;
                    break;
                } else {
                    if (isSameLength) {
                        oneDistance = true;
                        i1++;
                        i2++;
                    } else {
                        if(s.length() > t.length()) {
                            i1++;
                        } else {
                            i2++;
                        }
                        oneDistance = true;
                    }
                }
            }
        }
        
        if(isSame && ((s.length() - i1 == 1) || (t.length() - i2 == 1))) 
            return true;
        
        return oneDistance;
    }

}