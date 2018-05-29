package com.pranav.javagrok.problemsolving;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/course-schedule/description/
 * @author pbhatt
 *
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++){
            courses.add(new ArrayList<Integer>());
        }
        
        // course i -> all the prerequisites of course i
        for(int i=0;i<prerequisites.length;i++){
            courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] processed = new int[numCourses];
        for(int i=0; i< numCourses; i++){
            if(processed[i] == 0){
                if(!dfs(processed, courses, i)) return false;
            }
        }
        return true;
        
    }
    
    private boolean dfs(int[] processed, List<List<Integer>> courses, int i){
        processed[i] = 1;//start processing course i, mark it as temp
        
        List<Integer> prereqCourses = courses.get(i); // all the prerequisites of course i
        
        for(int k=0; k < prereqCourses.size(); k++){
            int prereqCourse = prereqCourses.get(k);
            if(processed[prereqCourse] == 1) return false; // marked temporarily, not a DAG
            if(processed[prereqCourse] == 2) continue; // marked Permanent, i.e fully processed
            if(!dfs(processed, courses, prereqCourse)) return false;
        }
        
        processed[i] = 2; // course i is full processed, no cycle found
        return true;
    }     
}