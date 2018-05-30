package com.pranav.javagrok.problemsolving;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LowestCommonAncestor {
	/*
	 * <left.val <= root.val <= right.val
	 */
	public TreeNode lowestCommonAncestorBinarySearchTree(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return root;
		if (root.val > p.val && root.val > q.val) {
			// lca lies on the LHS
			return lowestCommonAncestorBinarySearchTree(root.left, p, q);
		}

		if (root.val < p.val && root.val < q.val) {
			// lca lies on the RHS
			return lowestCommonAncestorBinarySearchTree(root.right, p, q);
		}

		return root;

	}
	
	public TreeNode lowestCommonAncestorBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root== p || root == q){
            return root;
        }
        
        TreeNode right = lowestCommonAncestorBinaryTree(root.right, p, q);
        TreeNode left = lowestCommonAncestorBinaryTree(root.left, p, q);
        
        if(left == null){
            return right;
        } 
        
        if(right == null){
            return left;
        }
        return root;
    }
}
