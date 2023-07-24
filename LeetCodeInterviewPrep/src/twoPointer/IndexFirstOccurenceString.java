package twoPointer;

public class IndexFirstOccurenceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IndexFirstOccurenceString obj=new IndexFirstOccurenceString();
		String haystack = "mississippi";
		String needle ="issip";
		
		
		

		System.out.println(obj.strStr(haystack, needle));
	}

	public int strStr(String haystack, String needle) {
		int len = haystack.length();
		int j = 0;
		for (int i = 0; i < len; i++) {
			char  a=haystack.charAt(i);
			char b= needle.charAt(j);
			if ( a == b ) {

				j++;
				if (j == needle.length()) {
					return i - j+1;
				}
			} else {
				i=i-j;
				j = 0;
			}
		}
		return -1;
	}

}
