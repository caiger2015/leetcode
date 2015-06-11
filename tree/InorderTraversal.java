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
public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        preOrder(root,res);
        return res;
    }
    private void preOrder(TreeNode p,ArrayList<Integer> res){
        if(p==null)
            return;
        preOrder(p.left,res);
        res.add(p.val);
        preOrder(p.right,res);
    }
}
