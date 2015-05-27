package leetcode.tree;

import java.util.Stack;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode pNode=new TreeNode(0);
		pNode.left=new TreeNode(1);
		TreeNode qNode=new TreeNode(0);
		qNode.left=new TreeNode(1);
		System.out.print(isSameTree(pNode,qNode)+"");
	}
	public static boolean isSameTree(TreeNode p,TreeNode q){
		if(p==null&&q==null)
            return true;
        else if(p==null||q==null)
            return false;
        Stack<TreeNode> stack1=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        while(p!=null&&q!=null){
            if(p.val!=q.val)
                return false;
            while(p!=null&&q!=null&&p.val==q.val){
                stack1.push(p);
                stack2.push(q);
                p=p.left;q=q.left;
            }
            if(p==null&&q==null){
                p=stack1.pop().right;
                q=stack2.pop().right;
            }
        }
        if(p==null&&q==null)
            return true;
        else
            return false;
	}


	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}

	 
