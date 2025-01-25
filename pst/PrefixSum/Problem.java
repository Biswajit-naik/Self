package PrefixSum;

import java.util.Arrays;


public class Problem {
    public static void main(String[] args) {
        int [] arr = {10 ,2 ,30 ,56 , 69 , 6};
        int k = 3;

        System.out.println("Array is :"+ Arrays.toString(arr) + "And k is :"+ k);

        for(int i=1;i<arr.length; i++){
            arr[i] = arr[i-1] + arr[i];
        }

        System.out.println("Array is :"+ Arrays.toString(arr));
        System.out.println("After the prefix sum : "+ k + "index is :"+ arr[k-1] );
    }
}
