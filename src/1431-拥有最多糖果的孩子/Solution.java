import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 *输入：candies = [2,3,5,1,3], extraCandies = 3
 * 输出：[true,true,true,false,true]
* */
public class Solution {
    public static void main(String[] args){
        int[] candies={4,2,1,1,2};
        int extraCandies=1;
        System.out.println(kidsWithCandies(candies,extraCandies));


    }


    /**
     * 首先找出数组中的最大的一个数，然后用这个最大数减去额外的糖果数
     * 再次循环数组，如果数组中的元素小于这个数就是false，否则为true
     * 时间复杂度为O(n),空间复杂度也为O(n)
    * */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list=new ArrayList<>();
        int max=0;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>max){
                max=candies[i];
            }
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i]<max-extraCandies){
                list.add(false);
            }else {
                list.add(true);
            }
        }
        return list;
    }

}
