package dynamicProgramming;

public class LongestPalindromicSubstring {
//5
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestPalindromicSubstring obj=new LongestPalindromicSubstring();
		String s="aaaabbaa";
		System.out.println(obj.longestPalindrome(s));
	}
	
public String longestPalindrome(String s) {
        //dp[i][j] resembles if subs from i to j is palindrome or not
        int len=s.length();
        int maxlength=1;
        int dp[][]=new int[len][len];
         int start=0;
        for(int i=0;i<len;i++){
            dp[i][i]=1;
            maxlength=1;
            start=i;
            
        }
        
        for(int i=0;i<len-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                maxlength=2;
                start=i;
            }
        }
       
        for(int k=3;k<=len;k++){
            
            for(int i=0;i<len-k+1;i++){
                
                int j=i + k-1;
                
                if(dp[i+1][j-1]==1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=1;
                    if(k>maxlength){
                        maxlength=k;
                        start=i;
                    }
                }
            }
        }
        
        return s.substring(start,start+maxlength);
    }

}
