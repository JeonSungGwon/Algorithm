import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int max = 0;
        int comp = 0;
        for(int i = 0 ; i < n ; i++){
            if(max < citations[i]){
                max = citations[i];
                comp = max/2;
            } 
        }
        while(comp > 0){
            int a = 0;
            int b = 0;
            for(int i = 0 ; i < n ; i++){
                if(citations[i] >= comp){
                    a++;
                }else{
                    b++;
                }
            }
            if(a >= comp && b <= comp){
                break;
            }else{
                comp--;
            }
        }
        return comp;
    }
}