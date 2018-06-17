package com.pranav.javagrok.problemsolving;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.pranav.javagrok.datastructures.TreeNode;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 * Two trees are duplicate if they have the same structure with same node values.
 * @author pbhatt
 *
 */
public class SubTree {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        getSerialized(root,map);
        List<TreeNode> result = map.entrySet().stream().filter(e -> e.getValue().size()>1).map(e -> e.getValue().get(0)).collect(Collectors.toList());
        return result;
    }
    
    private String getSerialized(TreeNode root,Map<String, List<TreeNode>> map){
        if(root == null) return "x";
        String key = null;
        String leftSerialized = getSerialized(root.left,map);
        String rightSerialized = getSerialized(root.right,map);
        key = root.val+"("+leftSerialized+","+rightSerialized+")"; 
        
        List<TreeNode> list = map.getOrDefault(key, new ArrayList<>());
        list.add(root);
        map.put(key, list);
        return key;
    }
}
