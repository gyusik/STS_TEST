package com.example.demo;

import java.util.HashMap;
import java.util.Map.Entry;

public class TestClass {

	public static void main(String[] args) {
		String[] participant = {"Leo", "kiki", "eden"};
        String[] completion = {"Eden", "kiki"};
    	System.out.println("solution() -> "+solution(participant, completion));

	}
	
	/** 1번 **/
	public static String solution(String[] participant, String[] completion) {
		String answer ="";
		
        HashMap<String, Boolean> solutionMap = new HashMap<>();
        if(participant.length > 0 && participant.length <= 100000){
        	int length = participant.length - completion.length;
	        if(length == 1){
	        	for(int i = 0 ; participant.length-1 >= i; i++) {
	        		participant[i] = participant[i].toLowerCase();
	        		solutionMap.put(participant[i], true);
	        	}
	        	
	        	for(int i = 0 ; completion.length-1 >= i; i++) {
	        		completion[i] = completion[i].toLowerCase();
	        		
	        		if(solutionMap.containsKey(completion[i])) {
	        			solutionMap.remove(completion[i]);
	        		}
	        	}
	        	
	        	for(Entry<String, Boolean> entry : solutionMap.entrySet()) {
	        		answer = entry.getKey();
	        	}
	        	
	        }
        }
        
        return answer;
        
//        String[] participant = {"Leo", "kiki", "eden"};
//        String[] completion = {"Eden", "kiki"};
//    	System.out.println("solution() -> "+solution(participant, completion));
    }
	
}
