package Slidingwindow;

public class Algorithm {

    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k= 3;

        int msum=0;


        //Brute Force
        // Timwe -> O(n*k) Space =O(1)
        for(int i=0;i<=arr.length-k;i++){
            int windowsum=0;
            for(int j=i;j<k+i;j++){
                windowsum += arr[j];
                msum=Math.max(windowsum,msum);
                System.out.print(arr[j]+" ");
            }
            System.out.println("");

        }

        System.out.println("maximum sum :"+msum);


//        System.out.println(maxSum(arr,k));
        System.out.println(WithSlidingT(arr,k));
    }
    // Slidingwindow
    private static int maxSum(int[] arr, int k) {
        int maxsum=0;

        for (int i=0;i<k;i++){
            maxsum +=arr[i];
        }

        int windowsum = maxsum;
        for (int i=k;i< arr.length;i++){
            windowsum += arr[i] - arr[i-k];
            maxsum = Math.max(maxsum,windowsum);
        }

        return maxsum;
    }
    /*
        This WithSlidingT through do in a singel loop
        Time : O(n)
        Space :O(1)
     */
    public static int WithSlidingT(int [] arr,int k ){
        int left = 0,right =0,count=0;
        int maxsum=0;
        int windowsum=0;

        while(right < arr.length){
            windowsum+=arr[right];
            if((right-left) == k-1){
                count++;
                maxsum=Math.max(maxsum,windowsum);
                windowsum-=arr[left];
                left++;
            }
            right++;
        }
        System.out.println("maximum "+count+" number of subarray is possible with "+ k +" window size");
        return maxsum;
    }



}
