/**
 * 求 1+2+...+n ，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
* */
public class Solution {
   static int sum=0;
    public static void main(String[] args){
        System.out.println(sumNums(2));
    }
    /**
     * 运用逻辑运行的短路效应代替常规的if判断
    * */
    public static int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        sum += n;
        return sum;
    }
}
