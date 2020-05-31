import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author yankaikai
 * @version 1.0
 * @date 2020/5/30 8:27
 * @description 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 例  [2,1,5,6,2,3]  最大的面积为10
 */
public class Solution {
    public static void main(String[] args){
        int[] heights={2,3};
        System.out.println(largestRectangleArea(heights));
    }


   /**
    *  维护一个单调栈，栈中总是保存递增元素的索引，当遇到比栈顶元素小的元素时，
    *  将栈顶元素依次出栈，每次都计算栈中的bar能围成的面积，直到栈顶元素小于当前元素就停止出栈
   * */
    public static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return heights[0];
        }
        int area=0;
        // 定义一个栈
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while (!stack.isEmpty()&&heights[stack.peekLast()]>heights[i]){
                int height=heights[stack.peekFirst()];

                int width;
                if(stack.isEmpty()){
                    width=i;
                }else {
                    width=i-stack.peekLast()-1;
                }
                area=Math.max(area,width*height);


                // 将数组下表存储栈中
                stack.addLast(i);
            }
        }

        while (!stack.isEmpty()){
            int height = heights[stack.removeLast()];

            while (!stack.isEmpty() &&  heights[stack.peekLast()] == height){
                stack.removeLast();
            }

            int width;
            if (stack.isEmpty()){
                width = n;
            } else {
                width = n - stack.peekLast() - 1;
            }

            area = Math.max(area , width * height);
        }
        return area;
    }


    /**
     * 暴力解法：高度一定，寻找最长的长度。时间复杂度为O(n^2),空间复杂度为O(1)
     * 求最大值时，固定一个值，去动态调整另一个值得大小
    * */
    public static int largestRectangleArea_2(int[] heights){
        int n=heights.length;
        if(n==0){
            return 0;
        }
        int area=heights[0];
        for(int i=0;i<n;i++){
            // 寻找左边位置
            int left=i;
            while (left-1>=0&&heights[left-1]>=heights[i]){
                left--;
            }
            // 寻找右边位置
            int right=i;
            while (right+1<n&&heights[right+1]>=heights[i]){
                right++;
            }
            area=Math.max(area,(right-left+1)*heights[i]);
        }
        return area;
    }

    /**
     * 引入哨兵的概念，在数组的两边分边加入元素0.
    * */
    public static int largestRectangleArea_3(int[] heights) {
        int n=heights.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return heights[0];
        }
        int[] newHeights = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newHeights[i + 1] = heights[i];
        }
        n += 2;
        heights = newHeights;
        int area=0;
        // 定义一个栈
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while (heights[stack.peekLast()]>heights[i]){
                int height=heights[stack.peekFirst()];
                int width=i-stack.peekLast()-1;
                area=Math.max(area,width*height);
            }
            // 将数组下表存储栈中
            stack.addLast(i);
        }
        return area;
    }
    /**
     * 单调栈：找两边第一个小于当前值得数，记录其位置。
    * */
    public int largestRectangleArea_4(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

}
