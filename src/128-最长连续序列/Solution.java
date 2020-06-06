import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
* */
public class Solution {
    public static void main(String[] args){
        int[] nums={100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }



    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set=new HashSet<>();
        // 将数组元素放入hash中，并去重
        for(int num:nums){
            num_set.add(num);
        }
        int longestStreak=0;
        for(int num:num_set){
            int currentNum=num;
            int currentStreak=1;
            while (num_set.contains(currentNum+1)){
                currentNum+=1;
                currentStreak+=1;
            }
            longestStreak=Math.max(longestStreak,currentStreak);
        }
        return longestStreak;
    }

    /**
     * 第一步：将所有数装进HashSet中；
     * 第二步：从数组第一个元素开始查HashSet,不仅要查它前面的，
     * 还要查它后面的，比如：3，2，1，4，6，查3，查前面的会查到2，1，
     * 查后面的会查到4。一旦一个元素被查到，直接将这个数从Set中移除，这样一来，
     * 3，2，1，4直接全被踢出Set；再开始查2，2已经被踢出去了（HashSet中不包含2），
     * 可以直接跳过，1，4亦是如此，最后查6。整个过程只需要记录中间最长的即可。
     *
    * */
    public int longestConsecutive_(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            hash.add(nums[i]);
        }
        int cnt = 0;
        int result = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        for(int j = 0; j < nums.length; j++){
            if(!hash.contains(nums[j])) continue;
            cnt = 0;
            tmp1 = nums[j];
            tmp2 = nums[j]+1;
            while(hash.contains(tmp1)) {
                cnt++;
                hash.remove(tmp1);
                tmp1--;
            }
            while(hash.contains(tmp2)) {
                cnt++;
                hash.remove(tmp1);
                tmp2++;
            }
            result = cnt > result ? cnt : result;
        }
        return result;
    }


}
