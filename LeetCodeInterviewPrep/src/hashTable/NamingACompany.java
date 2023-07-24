package hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NamingACompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ideas = {"coffee","donuts","time","toffee"};
		
		NamingACompany obj=new NamingACompany();
		
		System.out.println(obj.distinctNames(ideas));
	}

	public long distinctNames(String[] ideas) {

		HashMap<Integer, Set<String>> map = new HashMap();

		for (int i = 0; i < ideas.length; i++) {
			int first = ideas[i].charAt(0)-'a';
			map.putIfAbsent(first, new HashSet<String>());
			map.get(first).add(ideas[i].substring(1));
		}
		long res = 0;
		for (int i = 0; i < 26; i++) {
			for (int j = i + 1; j < 26; j++) {

				Set<String> setA = map.get(i);
				Set<String> setB = map.get(j);

				Set<String> isect = new HashSet<>(setA);
				//isect.addAll(setA);
				isect.retainAll(setB);

				res += 2 * (setA.size() - isect.size()) * (setB.size() - isect.size());
			}

		}

		return res;
	}

}
