package leetcode.tree;


public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //�����ȣ�Ҷ�ӽ�㵽���������·���ĳ���
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        if(root.left!=null&&root.right!=null)
            return 1+Math.min(minDepth(root.left),minDepth(root.right));
        if(root.left==null)
            return 1+minDepth(root.right);
        else
            return 1+minDepth(root.left);
    }
}