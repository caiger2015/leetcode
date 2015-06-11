/**
 * 
 */
package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caiger
 *
 */
public class PreorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        preOrder(root,res);
        return res;
    }
    private void preOrder(TreeNode p,ArrayList<Integer> res){
        if(p==null)
            return;
        res.add(p.val);
        preOrder(p.left,res);
        preOrder(p.right,res);
    }
}
