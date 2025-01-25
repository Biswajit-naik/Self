package Slidingwindow;

/*
    Maximum sum Of subarray
    window size not mention
    @LeetCode:53
    constraint: -10^4 <= nums[i] <= 10^4
 */
public class Problem3 {


    public static int optimal(int []arr){
        int maxsum=Integer.MIN_VALUE;

        if (arr.length == 1){
            return arr[0];
        }
        int i=0,windowsum=0;
        while(i<arr.length){
            windowsum += arr[i];
            if(windowsum > maxsum){
                maxsum=windowsum;
            }

            if(windowsum < 0){
                windowsum =0;
            }
            i++;
        }
        return maxsum;
    }


    public static void main(String[] args) {
        int []arr={-2,1,-3,4,-1,2,1,-5,4};
        int sum =0;
        System.out.println( "Optimal : "+optimal(arr));


//        for(int k=0;k< arr.length;k++ ){
            for(int i=0 ;i< arr.length;i++){

                for(int j=i;j<arr.length ; j++){
                    int windowsum=0;
                    for(int k=j;k< arr.length;k++) {
//                        System.out.print(arr[k] + " ");
                        windowsum+=arr[k];
                        sum = Math.max(windowsum,sum);
                    }
//                    System.out.println("");
                }
//                System.out.println("");
            }
//        }
        System.out.println("---------------->"+ sum);
    }
}


