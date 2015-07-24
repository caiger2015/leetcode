/**
 * 
 */
package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author caiger
 *
 */
public class BinarySearchTreeIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// 存储树中的每个节点
	private List<Integer> valList = new LinkedList<Integer>();
	private int index = 0;

	// 中序遍历BST结果为升序排列
	public BinarySearchTreeIterator(TreeNode root) {
		if (root == null)
			return;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode temp = root;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			temp = stack.pop();
			valList.add(temp.val);
			temp = temp.right;
		}
	}

	/** @return whether we have a next smallest number */
	// 每次调用hasNext，若还有下一个则指针向后移动一位
	public boolean hasNext() {
		if (index < valList.size()) {
			index++;
			return true;
		}
		return false;
	}

	/** @return the next smallest number */
	// 返回的是指针的前一个元素
	public int next() {
		return valList.get(index - 1);
	}
}
/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */

