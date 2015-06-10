/**
 * 
 */
package leetcode.tree;

import leetcode.tree.SameTree.TreeNode;

/**
 *@author caiger
 *Given a binary tree and a sum, 
 *determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
public class PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)
			return false;
		//因为是判定到叶子结点的路径，所以要在递归开始时判定当前结点是否是叶子结点
		if(root.left==null&&root.right==null)
			return root.val==sum?true:false;
		return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
	}
}
