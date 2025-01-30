package Slidingwindow;

import java.util.Arrays;

/*
 * find the length of longest substring with non repetating characters;
 * 
 */
public class Problem5 {
    public static int bruteforce(String s){
        int n= s.length()-1;
        int maxlen = 0;
        int len=0;

        for(int i=0;i<=n;i++){
            int[] array = new int[256];
            for(int j=0;j<=n;j++){
                if (array[s.charAt(j)]==1){
                    break;
                }
                len = j-i+1;
                maxlen=Math.max(maxlen, len);
                array[s.charAt(j)]=1;
            }
        }
        return maxlen;
    }

    public static int optimizesoln(String s) {
        int maxlen=0;
        int start=0;
        int end =0;
        int len= s.length()-1;
        int []hash = new int[256];
        Arrays.fill(hash,-1);

        while (end <= len) {
            if(hash[s.charAt(end)]!=-1){
                if(hash[s.charAt(end)] > start){
                    start = hash[s.charAt(end)]+1;
                }
            }
            len=end-start+1;
            maxlen = Math.max(maxlen, len);
            hash[s.charAt(end)]=end;
            end++;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s="cadbzacd";
        System.out.println(" length of longest substring with non repetating characters with Bruteforce way:"+bruteforce(s));
        System.out.println(" length of longest substring with non repetating characters with Slidingwindow way:"+optimizesoln(s));
        
    }
}


