package com.pranav.javagrok.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            
            List<String> slist = map.getOrDefault(key, null);
            if(slist == null){
                slist = new ArrayList<String>();
                slist.add(s);
                map.put(key,slist);
            }else{
                slist.add(s);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
