package com.pranav.javagrok.problemsolving;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/replace-words/description/
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - 
 * let's call this word successor. For example, the root an, followed by other, which can form another word another.
 * Now, given a dictionary consisting of many roots and a sentence. 
 * We need to replace all the successor in the sentence with the root forming it. 
 * If a successor has many roots can form it, replace it with the root with the shortest length.
 * We need to output the sentence after the replacement.
 *
 *@author pbhatt
 */
public class WordReplace {
    class TrieNode {
        Map<Character, TrieNode> children; 
        boolean word;
        String val;
        
        TrieNode(){
            children = new HashMap<>();
        }
        
        void setVal(String s){
            this.val = s;
        }
        
        String getVal(){
            String result=null;
            if(this.isWord()){
                result = this.val;
            }
            return result;//only the leaf nodes in the trie will store complete word
        }
        
        void markWord(){
            this.word=true;
        }
        
        boolean isWord(){
            return this.word == true;
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = createTrie(dict);
        if(sentence == null || sentence.length() == 0) return sentence;
        String[] sarray = sentence.split("\\s+");

        StringBuffer sb = new StringBuffer();
        for(String s:sarray){
            TrieNode r = searchRoot(s, root);
            if(r == null || r.getVal() == null){
                //no root found
                sb.append(s+" ");
            }else{
                sb.append(r.getVal()+" ");
            }
        }
        
        String result = sb.toString();
        return result.trim();
    }
    
    private TrieNode searchRoot(String prefix, TrieNode root){
        if(root == null) return null;
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            Character c = prefix.charAt(i);
            TrieNode n = curr.children.getOrDefault(c,null);
            curr =  n;
            if(curr == null || curr.isWord()){
                //no match or we found a root
                break;
            }
        }
        return curr;
    }
    
    private TrieNode createTrie(List<String> dict){
        TrieNode root = new TrieNode();
        for(String s:dict) insert(s, root);
        return root;
    }
    
    private void insert(String word, TrieNode root){
        if(root == null) root = new TrieNode();
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i);
            TrieNode n = curr.children.getOrDefault(c,null);
            if(n == null){
                n = new TrieNode();
                curr.children.put(c,n);
            }
            curr = n;
        }
        curr.markWord();//mark as a word
        curr.setVal(word);
    }
}
