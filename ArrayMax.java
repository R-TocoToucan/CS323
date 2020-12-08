	// THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
	// A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Minseok Choi
	// ArrayMax, passed all tests. 
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int[] a = new int[M]; // all zero
        
        PriorityQueue<value> pq = new PriorityQueue<value>(M, new valueComparator()); 
        
        
        for (int n=0; n<N; ++n) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            a[i] = v;
            
            pq.add(new value(i, v));
            
            while (a[pq.peek().getIndex()] != pq.peek().getValue()) {
                pq.poll();
                
            }
            System.out.println(pq.peek().getIndex());
        }
        br.close();
    }
    
    static class valueComparator implements Comparator<value>{ 
        
        @Override
        public int compare(value v1, value v2) {
             if (v1.value < v2.value) { 
                    return 1; 
             } else if (v1.value > v2.value) { 
                    return -1; 
             } else {
                 if (v1.index > v2.index) {
                     return 1; 
                 } else {
                     return -1;
                 }
             }
        } 
    } 

        static class value { 
            public int index; 
            public int value;
      
            // A parameterized student constructor 
            public value(int index, int value) { 
                
                this.index = index; 
                this.value = value; 
            } 
  
            public int getIndex() { 
                return index; 
            }  
            public int getValue() { 
                return value; 
            }
        
        }

}
