package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WordBreak2 obj=new WordBreak2();
		
		String s = "pineapplepenapple";
		String[] arr= {"apple","pen","applepen","pine","pineapple"};
		
				
				List<String> str=obj.wordBreak(s, Arrays.asList(arr));
				System.out.println(str);
	}

	HashMap<String, List<String>> map = new HashMap<String, List<String>>();

	/*
	 * public List<String> wordBreak(String s, List<String> wordDict) { List<String>
	 * res = new ArrayList<String>(); if (s == null || s.length() == 0) { return
	 * res; } if (map.containsKey(s)) { return map.get(s); } if
	 * (wordDict.contains(s)) { res.add(s); } for (int i = 1; i < s.length(); i++) {
	 * String t = s.substring(i); if (wordDict.contains(t)) { List<String> temp =
	 * wordBreak(s.substring(0, i), wordDict); if (temp.size() != 0) { for (int j =
	 * 0; j < temp.size(); j++) { res.add(temp.get(j) + " " + t); } } } } map.put(s,
	 * res); return res; }
	 */
	
	
	 public List<String> wordBreak(String s, List<String> wordDict) {
	        
	       
	        Set<String> dict= new HashSet<String>(wordDict);
	        return helper(s,dict);
	    }
	    
	    List<String> helper(String str,Set<String> dict){
	        List<String>  res=new ArrayList();
	        if(str.length()==0 || str==null){
	            return res;
	        }
	        if(map.containsKey(str)){
	            return map.get(str);
	        }
	        
	        if(dict.contains(str)){
	            res.add(str);
	        }
	        
	        for(int i=1;i<str.length();i++){
	            String pre=str.substring(0,i);
	            if(dict.contains(pre)){
	                List<String> temp=helper(str.substring(i),dict);
	                for(int j=0;j<temp.size();j++){
	                    res.add(pre+" "+ temp.get(j));
	                }
	            }
	        }
	        
	        map.put(str,res);
	        return res;
	        
	    }

}
