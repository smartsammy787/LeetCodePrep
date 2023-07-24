package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GroupAnagrams obj=new GroupAnagrams();
		String []strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(obj.groupAnagrams(strs));
	}

	 public List<List<String>> groupAnagrams(String[] strs) {
	        
	        HashMap<String,List<String>>  map=new HashMap();

	        for(int i=0;i<strs.length;i++){
	            String cur=strs[i];
	            int arr[]=new int[26];
	            StringBuilder sb=new StringBuilder();
	            for(int j=0;j<cur.length();j++){
	                    arr[cur.charAt(j)-'a']++;
	            }
	            for(int x=0;x<26;x++){
	                if(arr[x]!=0){
	                    sb.append((char)(x+'a'));
	                    sb.append(arr[x]);
	                }
	            }

	            if(!map.containsKey(sb.toString())){
	                map.put(sb.toString(),new ArrayList<String>());

	            }
	            map.get(sb.toString()).add(cur);
	        }

	        List<List<String>> ans=new ArrayList<>();

	        for(String key: map.keySet()){
	            ans.add(map.get(key));
	        }

	        return ans;
	        
	    }
}
