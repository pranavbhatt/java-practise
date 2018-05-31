package com.pranav.javagrok.problemsolving;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.pranav.javagrok.datastructures.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author pbhatt
 *
 */
public class BinaryTreeTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        if(root == null){
            return res;
        }
        
        st.push(root);
        
        while(!st.empty()){
            TreeNode node = st.pop();
            res.add(node.val);
            if(node.right!=null){
                st.push(node.right);
            }
            if(node.left!=null){
                st.push(node.left);
            }
        }
        
        return res;
        
    }
	
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        if(root == null){
            return result;
        }
        
        st1.push(root);
        
        while(!st1.empty()){
            TreeNode node = st1.peek();
            if(node.left == null && node.right == null){
                result.add(st1.pop().val);
            }else {
                if(node.right!=null){
                    st1.push(node.right);
                    node.right = null;
                }
                
                if(node.left!=null){
                    st1.push(node.left);
                    node.left = null;
                }
            }
        }
        return result;
    }
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        if(root == null){
            return result;
        }
        
        st.push(root);
        
        while(!st.empty()){
            TreeNode node = st.peek();
            
            if(node.left != null){
                st.push(node.left);
                node.left = null;//break the link
                continue;
            }
            st.pop();//remove node fromt the stack
            if(node.right!=null){
                st.push(node.right);
            }
            result.add(node.val);
        }
        
        return result;
    }
	
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> levelQ = new LinkedList<>();
        levelQ.add(root);
        
        while(!levelQ.isEmpty()){
            List<Integer> levelResult = new ArrayList<>();
            Queue<TreeNode> nextLevelQ = new LinkedList<>();
            
            while(!levelQ.isEmpty()){
                TreeNode node = levelQ.remove();
                levelResult.add(node.val);
                if(node.left != null){
                    nextLevelQ.add(node.left);
                }
                
                if(node.right != null){
                    nextLevelQ.add(node.right);                    
                }
            }
            
            result.add(levelResult);
            levelQ = nextLevelQ;
        }
        
        return result;
    }
}
