package assignments;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N, I;
        StringBuilder L = new StringBuilder(); 
        
        N = sc.nextInt();
        I = sc.nextInt();
        sc.nextLine(); // finish first line
        while (sc.hasNextLine() ) {
            L.append(sc.nextLine());
        }
        sc.close();
        
        class BWT implements Comparable<BWT>{
            char character;
            int index;
            
            public BWT(char c, int i) {
                this.character = c;
                this.index = i;
            }
            public int getIndex() {
                return index;
            }
            public String toString() {
                return Character.toString(character);
            }
            public int compareTo(BWT b) {
                if (this.character < b.character) {
                    return -1;
                } else if (this.character > b.character) {
                    return 1;
                } else {
                    return 0;
                }
            }    
        }

        BWT[] BWT = new BWT[N];
        

        for (int i = 0; i < N; i++) {
            BWT[i] = new BWT(L.charAt(i), i);
        }
        Arrays.sort(BWT);
        
        StringBuilder ans = new StringBuilder();
        
        int l = BWT[I].getIndex();
        
        for (int i=0; i<N; i++) {    
            if (i>0 && i%40 == 0) {
                ans.append("\n");
            }
            ans.append(Character.toString(L.charAt(l)));
            l = BWT[l].getIndex();
            }
        
            System.out.println(ans);
    }
   
}