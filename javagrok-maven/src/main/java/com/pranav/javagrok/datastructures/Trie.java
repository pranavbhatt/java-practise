package com.pranav.javagrok.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 * 
 * Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class Trie {
    class TrieNode{
        Map<Character, TrieNode> children;
        private boolean flag;
        TrieNode(){
            children = new HashMap<>();
        }
        
        void markWord(){
            this.flag = true;
        }
        
        boolean isWord(){
            return this.flag == true;
        }
    }
    
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i);
            TrieNode n = curr.children.getOrDefault(c, null);
            if(n==null){
                n = new TrieNode();
                curr.children.put(c,n);
            }
            curr = n;
        }
        curr.markWord();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode k = searchPrefix(word);
        return k!=null&&k.isWord();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode k = searchPrefix(prefix);
        return k != null;
    }
    
    /** Returns the node representing last character of prefix */
    private TrieNode searchPrefix(String prefix){
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            Character c = prefix.charAt(i);
            TrieNode n = curr.children.getOrDefault(c,null);
            if(n == null) return n;
            curr = n;
        }
        return curr;
    }
}
