package Slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Maximum number of Fruit baseket 
 * 2 size we can store the single type of fruit only
 */
public class Problem7 {

    private static int BruteForce(int []fruits) {
        int maxlen =0;
        // Set<Integer> s = new HashSet<>();

        for(int i=0 ; i< fruits.length ; i++){
            Set<Integer> s = new HashSet<>();
            for (int j=i;j< fruits.length;j++){
                s.add(fruits[j]);

                if(s.size() <= 2 ){
                    maxlen = Math.max(maxlen, j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxlen;
    }

    private static int Bettersoln(int []f){
        int l=0;
        int r=0;
        int maxlen =0;
        Map<Integer,Integer> m = new HashMap<>();
        while (r<f.length) {
            if(m.containsKey(f[r])){
                m.put(f[r], m.get(f[r])+1);
            }else{
                m.put(f[r],1);
            }

            if (m.size()>2){
                while(m.size()>2){
                    System.out.println("map is:"+m);
                    if(m.containsKey(f[l])){
                        m.put(f[l], m.get(f[l])-1);
                        if(m.get(f[l])==0) {
                            m.remove(f[l]);
                        }  
                    } 
                    l++;   
                }    
            }
            System.out.println("after trim the size map is :"+m);
            if (m.size() <= 2){
                maxlen = Math.max(maxlen, r-l+1);
            }
            r++;
        }
        return maxlen;
    } 

    public static int Optimalsoln(int[] arr){
        
        int maxlen=0;
        int l=0;int r=0;
        Map<Integer,Integer> p = new HashMap<>();

        while (r< arr.length) {
            if (p.containsKey(arr[r])){
                p.put(arr[r],p.getOrDefault(arr[r],  0)+1);
            }else{
                p.put(arr[r], 1);
            }

            if(p.size()>2){
                if(p.containsKey(arr[l])){
                    p.put(arr[l], p.get(arr[l])-1);
                    if(p.get(arr[l])==0) {
                        p.remove(arr[l]);
                    }  
                } 
                l++;  
            }

            if (p.size() <=2){
                maxlen = Math.max(maxlen, r-l+1);
            }
           r++;
        }
        
        return maxlen;
    }


     
    public static void main(String[] args) {
        int [] arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("optimal answer is :"+Optimalsoln(arr) );
        // System.out.println(Bettersoln(arr));
        System.out.println("After solving with bruteforce techniques:"+BruteForce(arr));
    }       
        
           
}
