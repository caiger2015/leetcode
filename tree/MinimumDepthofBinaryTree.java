package leetcode.tree;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 最低深度：叶子结点到根结点的最短路径的长度
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (root.left != null && root.right != null)
			return 1 + Math.min(minDepth(root.left), minDepth(root.right));
		if (root.left == null)
			return 1 + minDepth(root.right);
		else
			return 1 + minDepth(root.left);
	}
}
