/*
 * Longest Repeteting chracter replacement
 * Given k , kth character replacemetn will be allowed
 */

import java.util.HashMap;
import java.util.Map;

public class Problem8{

    private static int SolutinoBruteForce(String str, int k) {
        int maxlen=0;

        for(int i=0;i< str.length();i++){
                int []arr = new int[130];   //it taking constant space
                int maxfreq =0;
            for(int j=i;j<str.length();j++){
                arr[str.charAt(j)]++;
                maxfreq = Math.max(maxfreq, arr[str.charAt(j)]);
                int changes = (j-i+1) -maxfreq;
                if (changes <= k){
                    maxlen = Math.max(maxlen, j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxlen;
    }        

    // private static int SolutionOptimal(String str, int k) {
    //     int l = 0;
    //     int r = 0;
    //     int maxlen = 0;
    //     // Use a HashMap to store character frequencies
    //     Map<Character, Integer> map = new HashMap<>();
    //     int maxfreq = 0;

    //     while (r < str.length()) {
    //         // Add the character at the right pointer to the map
    //         char currentChar = str.charAt(r);
    //         map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            
    //         // Update the max frequency of the character in the map
    //         maxfreq = Math.max(maxfreq, map.get(currentChar));

    //         // Check if the length of the substring minus max frequency is greater than k
    //         while ((r - l + 1) - maxfreq > k) {
    //             // Remove character at the left pointer from the map
    //             char leftChar = str.charAt(l);
    //             map.put(leftChar, map.get(leftChar) - 1);
    //             if (map.get(leftChar) == 0) {
    //                 map.remove(leftChar); // Remove it completely if frequency is zero
    //             }

    //             // Recalculate the max frequency in the map (could be optimized further)
    //             maxfreq = map.values().stream().max(Integer::compare).orElse(0);

    //             l++; // Shrink the window from the left
    //         }

    //         // Update maxlen if the substring length is valid
    //         if ((r - l + 1) - maxfreq <= k) {
    //             maxlen = Math.max(maxlen, r - l + 1);
    //         }
    //         r++; // Move the right pointer
    //     }

    //     return maxlen;
    // }

    private static int SolutionOptimal(String str, int k) {
        int l=0;
        int r=0;
        int maxlen=0;
        int arr[] = new int[125]; //make own has through array O(125)
        int maxfreq=0;
        while (r < str.length()) {
            arr[str.charAt(r)]++;
            maxfreq = Math.max(maxfreq, arr[str.charAt(r)]);

            //case for if possible-replace-char(Length - maxFreq ) > K
            if ((r-l+1)- maxfreq > k) {
                arr[str.charAt(l)]--;
                // int maxj=0;
                // for(int i=0;i<=25;i++) maxj=Math.max(maxj, arr[i]);
                l+=1;
            }

            //if the length under K
            if ((r-l+1)- maxfreq <= k){
                maxlen=Math.max(maxlen, r-l+1);
            }   
            r++;
        }
        

        return maxlen;
    }
    public static void main(String[] args) {
        String str = "AABABBA";
        int k=2;
        // System.out.println("decef");        
        System.out.println("length of longest substring is :"+SolutinoBruteForce(str,k));
        System.out.println("length of longest substring is :"+SolutionOptimal(str,k));
    }        
}