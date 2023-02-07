package competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import competitor.Competitor;

public class Operation {
	/**
	 * calculate the log base 2 of a number
	 * @param N the number to which calculate the log2
	 * @return the log 2 of N
	 */
	 public static  int log2(int N){
		 
	        // calculate log2 N indirectly
	        // using log() method
	        int result = (int)(Math.log(N) / Math.log(2));
	 
	        return result;
	    }
	 
		/**
		 * return true if N is power of 2
		 * @param N the number to verify
		 * @return true if N is power of 2 else false
		 */
		public static boolean islog2(int N) {
			if (N==1) {
				return true;
			}
			else if(N%2!=0){
				return false;
				
			}	
			return islog2(N/2); 
			
		}
		
		
		/**
		 * get the first of a ranking
		 * @param rank map that contains competitors and theirs points
		 * @return Competitor the first competitor according theirs points
		 */
		
		public static Competitor getfst(Map<Competitor,Integer>rank){
			  Map.Entry<Competitor,Integer> maxEntry = null;
		        for (Map.Entry<Competitor, Integer> entry : rank.entrySet()) {
		            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
		                maxEntry = entry;
		            }
			
		}
		        return maxEntry.getKey();
		}
		

		/**
		 * get nth first competitor of a ranking 
		 * @param rank map that contains competitors and theirs points
		 * @param n the number of competitor to select
		 * @return Competitor the first competitor according theirs points
		 */
		 
		
		public static List <Competitor> getNthfst(Map<Competitor,Integer> rank ,int n){
			List<Competitor> qualifiers =new ArrayList<>();
			for(int i=0;i<n;i++) {
				Competitor c=Operation.getfst(rank);
				qualifiers.add(c);
				rank.remove(c);		
			}
			return qualifiers;
			
			
		}
		
		
		
		
		
				 
			
			
		
		
		
		
		
		
		
		
}
