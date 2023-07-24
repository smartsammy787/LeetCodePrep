package unionFind;

public class LexoSmallestEquivalentString {
	//1061
	
	int graph[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LexoSmallestEquivalentString obj=new LexoSmallestEquivalentString();
		String s1 = "parker";
		String s2 = "morris";
		String baseStr = "parser";
		System.out.println(obj.smallestEquivalentString(s1, s2, baseStr));
	}

	public String smallestEquivalentString(String s1, String s2, String baseStr) {
		graph=new int[26];
		
		for(int i=0;i<26;i++) {
			graph[i]=i;
		}
		
		for(int i=0;i<s1.length();i++) {
			int a=s1.charAt(i)-'a';
			int b=s2.charAt(i)-'a';
			
			int parA=find(a);
			int parB=find(b);
			if(parA<parB) {
				graph[parB]=parA;
			}else {
				graph[parA]=parB;
			}
		
			
		}
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<baseStr.length();i++) {
			char c=baseStr.charAt(i);
			sb.append((char)(find(c-'a')+'a'));
		}
		return sb.toString();
		
	}
	
	int find(int x) {
		while(x!=graph[x]) {
			x=graph[x];
		}
		return x;
	}
}
