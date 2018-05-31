package com.pranav.javagrok.problemsolving;

import java.util.Stack;

import com.pranav.javagrok.datastructures.TreeNode;

public class BstIterator{
    Stack<TreeNode> st;
    public BstIterator(TreeNode root) {
        st = new Stack<>();
        if(root!=null) st.push(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.peek();
         while(node.left != null){
             TreeNode left= node.left;
             node.left = null;
             st.push(left);
             node = left;
        }
        
        node = st.pop();
        if(node.right!=null){
            st.push(node.right);
            node.right = null;
        }
        
        return node.val;
    }
}