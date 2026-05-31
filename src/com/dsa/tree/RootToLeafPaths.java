package com.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*      0
     1     2
  3    4  5  2
*/

class TreeNode{
   public int data;
   public TreeNode left;
   public TreeNode right;
   public TreeNode(int data){
       this.data = data;
       this.left = null;
       this.right = null;
   }
}
class Pair{
    public TreeNode node;
    public int sum;
    public List<Integer> pr;
    public Pair(TreeNode node, int sum, List<Integer> pr){
        this.node = node;
        this.sum = sum;
        this.pr = pr;
    }
}
public class RootToLeafPaths {
    public static List<List<Integer>> rootToLeafPathWithTargetSum(TreeNode root, int target) {
        List<List<Integer>> resList = new ArrayList<>();

        List<Integer> pr = new ArrayList<>();
        pr.add(root.data);
        Pair source = new Pair(root, root.data, pr);

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(source);

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            TreeNode n = p.node;
            int sum = p.sum;
            List<Integer> resTill = p.pr;
            if(n.left == null && n.right == null){
                if(sum == target){
                    resList.add(resTill);
                }
            }

            if(n.left != null){
                List<Integer> leftPr = new ArrayList<>(resTill);
                leftPr.add(n.left.data);
                Pair left = new Pair(n.left, sum + n.left.data ,  leftPr);
                queue.offer(left);
            }
            if(n.right != null){
                List<Integer> rightPr = new ArrayList<>(resTill);
                rightPr.add(n.right.data);
                Pair right = new Pair(n.right, sum + n.right.data ,  rightPr);
                queue.offer(right);
            }
        }
        return resList;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);


        System.out.println(rootToLeafPathWithTargetSum(root, 4));



    }
}
