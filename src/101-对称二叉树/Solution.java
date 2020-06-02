import java.lang.reflect.Array;
import java.util.*;

/**
 * @author yankaikai
 * @version 1.0
 * @date 2020/5/31 8:59
 * @description   给定一个二叉树，检查它是否是镜像对称的。
 */
public class Solution {

    public static void main(String[] args){
        TreeNode t=new TreeNode(1);
        TreeNode t1=new TreeNode(2);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(2);
        TreeNode t4=new TreeNode(2);
        t.left=t1;
        t.right=t2;
        t1.left=t3;
        t2.left=t4;
        System.out.println(isSymmetric(t));

    }

    /**
     * 对树进行中序遍历，然后判断保存下来的数是否对象
    * */
    public static boolean isSymmetric(TreeNode root) {
      return check(root,root);

    }
     /**
      * 使用深度遍历：利用递归进行遍历
     * */
    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
    /**
     * 使用广度遍历，，借助队列进行判断
    * */
    public boolean check_2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }



    /**
     * @description 二叉树的中序遍历函数
     * @param 头结点
     * @return 数组
     */
    public static void middlefind(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        middlefind(root.left, list);
        list.add(root.val);
        middlefind(root.right, list);

    }


}
