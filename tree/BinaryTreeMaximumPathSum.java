/**
 * 
 */
package leetcode.tree;

/**
 * @author caiger
 *
 */
public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

	}

	private int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		dfs(root);
		return max;
	}

	/**
	 * @param root
	 *            多root结点求路径和：1.以该节点为根结点，两侧都考虑的pathsum与max比较作为最大和
	 *            2.以该节点为左/右子结点，只考虑一侧路径时，返回最大和，利用递归进行动态规划
	 *            description：采用递归进行动态规划，最终解是每个结点为根时的最大路径和的最大值，子问题是左右子结点的路径最大和
	 *            由于先要求出左右子结点的路径和，故采用后序遍历的DFS
	 */
	private int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		int curMax = root.val;
		if (left > 0)
			curMax += left;
		if (right > 0)
			curMax += right;
		// 比较每个子问题的最大路径和，更新max
		max = Math.max(max, curMax);
		// 返回以root为子结点的一侧路径最大值
		return Math.max(left + root.val, Math.max(right + root.val, root.val));
	}

}
