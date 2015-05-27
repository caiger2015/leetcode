package leetcode.tree;

import java.util.*;

import leetcode.tree.SameTree.TreeNode;


/*
 * Given a binary tree, return the level order traversal of its nodes' values.
 */
public class LevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		levelOrder(root);
	}
	public static List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(root==null)
			return res;
		//List<Integer> nextList=new ArrayList<Integer>();
		Queue<TreeNode> que=new ArrayDeque<TreeNode>();
		int pre=1,now=0;
		que.add(root);
		while(!que.isEmpty()){
			//地方变量应当在循环内定义，每次都建立新实例
			List<Integer> nextList=new ArrayList<Integer>();
			//nextList.clear();在res中添加的是nextList的引用类型，这一步会把res中的nextList也清空！
			while(pre!=0){
				TreeNode temp=que.poll();
				pre--;
				nextList.add(temp.val);
				if(temp.left!=null){
					que.add(temp.left);
					now++;
				}
				if(temp.right!=null){
					que.add(temp.right);
					now++;
				}	
			}
			pre=now;
			now=0;
			res.add(nextList);
		}
		return res;
	}
	public static List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(root==null)
			return res;
		//List<Integer> nextList=new ArrayList<Integer>();
		Stack<List<Integer>> stack=new Stack<List<Integer>>();
		Queue<TreeNode> que=new ArrayDeque<TreeNode>();
		int pre=1,now=0;
		que.add(root);
		while(!que.isEmpty()){
			//地方变量应当在循环内定义，每次都建立新实例
			List<Integer> nextList=new ArrayList<Integer>();
			//nextList.clear();在res中添加的是nextList的引用类型，这一步会把res中的nextList也清空！
			while(pre!=0){
				TreeNode temp=que.poll();
				pre--;
				nextList.add(temp.val);
				if(temp.left!=null){
					que.add(temp.left);
					now++;
				}
				if(temp.right!=null){
					que.add(temp.right);
					now++;
				}	
			}
			pre=now;
			now=0;
			stack.add(nextList);
		}
		while(!stack.isEmpty()){
			res.add(stack.pop());
		}
		return res;
	}	
}
	

