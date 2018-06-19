package com.pranav.javagrok.datastructures;

/**
 * Very un-optimized hash map implementation
 * 
 * Leetcode: https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1140/
 * 
 * Design a HashMap without using any built-in hash table libraries.
 * To be specific, your design should include these two functions:
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 * 
 * @author pbhatt
 *
 */
class MyHashMap {
    private static int INIT_SIZE=16;// in real hash map we double the table size when threshold = capacity*load_factor is reached
    Node[] table;
    
    class Node{
        int key;
        int value;
        int hash;
        Node next;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new Node[INIT_SIZE];
    }
    
    /** value will always be positive. */
    public void put(int key, int value) {
        int hash = getHashFromKey(key);
        Node n = new Node(key, value);
        n.hash = hash;
        
        Node head = this.table[hash];
        Node prev = head;
        
        while(head != null){
            if(head.key == key){
                head.value = value;//update and return
                return;
            }
            prev = head;
            head = head.next;
        }
        
        if(prev==null){
            this.table[hash] = n;
        }else{
            prev.next = n;
        } 
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = getHashFromKey(key);
        Node head = this.table[hash];
        int result = -1;
        while(head!=null){
            if(head.key == key){
                result = head.value;
                break;
            }
            head = head.next;
        }
        return result;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = getHashFromKey(key);
        Node head = this.table[hash];
        Node prev = head;
        while(head != null){
            if(head.key == key){
                if(prev == head){
                    this.table[hash] = head.next;
                }else{
                    prev.next = head.next;
                }
            }
            prev = head;
            head = head.next;
        }
    }
    
    private int getHashFromKey(int key){
        Integer i = key;
        return i.hashCode()%INIT_SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */