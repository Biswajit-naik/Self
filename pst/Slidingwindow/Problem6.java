package Slidingwindow;
/*
 * Max consecutive ones
 * we can flip only k zero & count the max length of consecutive ones;
 * 
 */
public class Problem6 {

    public static int optimizesoln(int[] arr,int k){
        int l=0;
        int r=0;
        int zero =0;
        int maxlen=0;
        int len=0;

        while (r < arr.length) {
            if(arr[r] == 0){
                zero++;
            }
            if (zero > k){
                if (arr[l]==0){ zero--;}               //when zero is increae more then k ,we need to trim down also;
                l++;
            }
            if (zero <= k){
                len = r-l+1;
                maxlen=Math.max(len, maxlen);           //zero is less then equal to k then we consider then length;
            }
            r++;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int []arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k=2;

        System.out.println("after the applying slidingwindow tehinque ,the length is :" +optimizesoln(arr, k));
    }
}
