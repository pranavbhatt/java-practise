package com.pranav.javagrok.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description: https://leetcode.com/problems/lru-cache/description/
 * 
 * 
 * LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class LRUCache {
    Map<Integer, LRUNode> lruMap;
    int capacity;
    LRUList lruList;
    
    //LRU cache node
    class LRUNode{
        int val;
        int key;
        LRUNode next;
        LRUNode prev;
        
        LRUNode(int key ,int val){
            this.val = val;
            this.key = key;
        }
        
        LRUNode(){}
    }
    
    //Doubly LinkedList of LRU cache nodes
    class LRUList{
        LRUNode head;
        LRUNode tail;
        
        LRUList(){
            this.head = new LRUNode();
            this.tail = new LRUNode();
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }
        
        void add(LRUNode node){
            if(node == null) return;
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        
        void remove(LRUNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
        
        
        LRUNode pop(){
            LRUNode node = tail.prev;
            if(node != head){
                this.remove(node);
            }else{
                node = null;
            }
            return node;
        }
        
        void makeRecent(LRUNode node){
            this.remove(node);
            this.add(node);
        }
    }
    
    public LRUCache(int capacity) {
        this.lruList = new LRUList();
        this.lruMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        LRUNode node = lruMap.getOrDefault(key, null);
        if(node != null){
            this.lruList.makeRecent(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {        
        LRUNode node = this.lruMap.getOrDefault(key, null);
        if(node == null){
            if(lruMap.size() == capacity){
                lruMap.remove(this.lruList.pop().key);
            }   
            node = new LRUNode(key, value);
            this.lruMap.put(key, node);
            this.lruList.add(node);
        }else{
            node.val = value;
            this.lruList.makeRecent(node);
        }
    }
}