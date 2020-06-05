import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
* */
public class Solution {
    public static void main(String[] args){
        int[] nums={0,0};
        int[] result=productExceptSelf(nums);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }

    }


    /**
     * 暴力解法：从当前位置从左到右依次相乘求得最终结果
    * */
    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] outputs=new int[n];
        for(int i=0;i<n;i++){
            int sum=1;
            int left=i;
            int right=i;
            while (left-1>=0){
                sum*=nums[left-1];
                left--;
            }
            while (right+1<n){
                sum*=nums[right+1];
                right++;
            }
            outputs[i]=sum;
        }
        return outputs;
    }

    /**
     * 除去当前的值=前缀之积*后缀之积。
    * */
    public int[] productExceptSelf_2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }
}
