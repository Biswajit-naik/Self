package Twopointer;

import java.util.Arrays;

public class Twosum {

    /*
    TwoSum Problem
    @LeetCode:1

    solve this in less then O(n^2);
    Constaints : 
    2 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9
    -10^9 <= target <= 10^9
*/
    private static int[] Solution(int[] arr, int target) {

        //make a hashtable to store large arr of (values.index); Space -> O(n)
        int [][] temp = new int[arr.length][2];// [row] [colum]
        for (int i =0 ; i< arr.length ; i++ ){
            temp[i] = new int[]{arr[i],i};
        }
        //sort 
        Arrays.sort(temp, (a, b) -> Integer.compare(a[0], b[0]));
    
        //applying twopointer stretegies;
            int left=0;
            int right=arr.length-1;
    
            while(left<right){
                int sum = temp[left][0] + temp[right][0];
                if (sum == target){
                    return new int[]{temp[left][1],temp[right][1]};
                }else if (sum > target){
                    right--;
                }else{
                    left++;
                }
            }
        return arr;
    }
    public static void main(String[] args) {

    int arr1[] = {2,7,11,15};
    int target1= 9;

    int arr2[]={3,2,4};
    int target2 = 6;

    System.out.println(Arrays.toString(Solution(arr2,target2)));


    }
}

