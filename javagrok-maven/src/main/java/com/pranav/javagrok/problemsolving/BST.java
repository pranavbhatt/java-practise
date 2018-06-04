package com.pranav.javagrok.problemsolving;

import com.pranav.javagrok.datastructures.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * @author pbhatt
 *
 */
public class BST {
	
	public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        if(root.val < val) return searchBST(root.right, val);
        return searchBST(root.left, val);
    }
	
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        
        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        //base case
        if(root == null) return root;
        
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);            
        }else{
            //this is the node to be deleted, root.val == key
            //if node has one child or no child
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            
            //has 2 children, find inorder succesor
            root.val = successor(root.right);
            root.right = deleteNode(root.right, root.val);//remove the copied node
        }
        return root;
    }
    
    private int successor(TreeNode root){
        int min = root.val;
        while(root.left != null){
            min = root.left.val;
            root = root.left;
        }
        return min;
    }
}
