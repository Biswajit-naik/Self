package Slidingwindow;

/*
 * maximum points obtain from a k size of card;
 * take either from front or end 
 */
public class Problem4 {

    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,1};
        int k=4;

        System.out.println(maxScore(arr,k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int lsum=0;
        int rsum=0;
        int maxsum=0;
        int rindex=cardPoints.length-1;
        
        for(int i=0;i< k;i++){
            lsum+=cardPoints[i];
        }               // O(k)
        maxsum=lsum;
        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[rindex];
            rindex-=1;
            maxsum=Math.max(maxsum,lsum+rsum);
    
        }  //O(n);
        return maxsum;
    }
}