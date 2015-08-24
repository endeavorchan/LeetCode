package uglyNumber2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    /**
     * 求第N个丑数
     * @param n
     * @return 第N个丑数
     */
    public int nthUglyNumber(int n) {
         
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
//      System.out.println("uglyNumbers[0]:1");
         
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
 
        int counter = 1;
        while (counter < n) {
 
//          System.out.println("-----------");
//          System.out.println("idx2:" + idx2 + ";ugly[idx2]:" + uglyNumbers[idx2]);
//          System.out.println("idx3:" + idx3 + ";ugly[idx3]:" + uglyNumbers[idx3]);
//          System.out.println("idx5:" + idx5 + ";ugly[idx5]:" + uglyNumbers[idx5]);
//          System.out.println("idx2:" + idx2 + ";idx3:" + idx3 + ";idx5:" + idx5);
             
            int min = minOf(
                uglyNumbers[idx2] * 2, 
                uglyNumbers[idx3] * 3, 
                uglyNumbers[idx5] * 5);
             
            if (min == uglyNumbers[idx2] * 2) {
//              System.out.println("min==ugly[idx2]*2:" + uglyNumbers[idx2] * 2);
//              System.out.println("idx2:" + idx2 + "→" + (idx2 + 1));
                idx2++;
            }
 
            if (min == uglyNumbers[idx3] * 3) {
//              System.out.println("min==ugly[idx3]*3:" + uglyNumbers[idx3] * 3);
//              System.out.println("idx3:" + idx3 + "→" + (idx3 + 1));
                idx3++;
            }
 
            if (min == uglyNumbers[idx5] * 5) {
//              System.out.println("min==ugly[idx5]*5:" + uglyNumbers[idx5] * 5);
//              System.out.println("idx5:" + idx5 + "→" + (idx5 + 1));
                idx5++;
            }
             
            uglyNumbers[counter] = min;
//          System.out.println("uglyNumbers[" + counter + "]:" + min);
            counter++;
        }
 
//      System.out.println("-----------");
//      System.out.println("return:" + uglyNumbers[n - 1]);
         
        return uglyNumbers[n - 1];
    }
     
    /**
     * 求三个数字中最小的数字
     * @param a 数字a
     * @param b 数字b
     * @param c 数字c
     * @return a、b、c中最小的数字
     */
    private int minOf(int a, int b, int c) {
        int temp = a < b ? a : b;
        return temp < c ? temp : c; 
    }
}
