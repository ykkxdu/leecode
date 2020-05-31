/**
 * @author yankaikai
 * @version 1.0
 * @date 2020/5/29 10:56
 * @description  小偷偷现金，有一条相连的房屋，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 例：[1,2,3,1]  偷1号和3号最多为4
 *
 * 递推公式 ：result[i]=max{result[i-1],result[i-2]+nums[i]}
 */
public class Solution {
    public static void main(String[] args){
        int[] money={2,1,1,2};
        System.out.println(maxMoney_2(money));
    }



    /**
     * @description  计算偷盗的最大金额，时间复杂度为O(n),空间复杂度为O(n)
     * @param  非负整数数组
     * @return  最大金额
     */
    public static int maxMoney(int[] nums){
       int n=nums.length;
       if(n==0){
           return 0;
       }
       if(n==1){
           return nums[0];
       }
       int[] result=new int[n];
       result[0]=nums[0];
       result[1]=Math.max(result[0],nums[1]);
       for(int i=2;i<n;i++){
           result[i]=Math.max(result[i-1],result[i-2]+nums[i]);
       }
        return result[n-1];

    }
    /**
     * 时间复杂度为O(n),空间复杂度为O(1)
    * */
    public static int maxMoney_2(int[] nums){
        int n=nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        int first=nums[0];
        int second=Math.max(nums[0],nums[1]);
        // 使用滚动数组将空间复杂度降到O(1)
        for(int i=2;i<n;i++){
            int temp=second;
            second=Math.max(second,first+nums[i]);
            first=temp;
        }
        return second;
    }
}
