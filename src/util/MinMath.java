
package util;


public class MinMath {
    public static int intAbs(int val){
        return val < 0 ? -val : val;
    }
    
    public static int intMin(int a, int b){
        int res = a < b ? a : b;
        return res;
    }
}
