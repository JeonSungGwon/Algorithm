import java.util.*;
import java.io.*;

class Solution {
    static int[] arrayAG;
    static int[] arrayBG;
    static int answer = 0;
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        arrayAG = arrayA;
        arrayBG = arrayB;
        
        selectCard(arrayA, 0);
        selectCard(arrayB, 1);
        
        return answer;
    }
    
    public void selectCard(int[] array, int num){
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        q.offer(array[0]);
        for(int i = 2 ; i < array[0]/2+1 ; i++){
            if(array[0] % i == 0){
                q.offer(i);
            } 
        }
        while(!q.isEmpty()){
            int target = q.poll();
            boolean arrA = false;
            boolean arrB = false;
            if(num == 0){
               for(int i = 0 ; i < arrayAG.length ; i++){
                    if(arrayAG[i] % target == 0){
                        arrA = true;
                    }else{
                        arrA = false;
                        break;
                    }
                }
                for(int i = 0 ; i < arrayBG.length ; i++){
                    if(arrayBG[i] % target == 0){
                        arrB = true;
                        break;
                    }
                }
            
                if(arrA && !arrB){
                    answer = Math.max(answer, target);
                    return;
                } 
            }else if(num == 1){
               for(int i = 0 ; i < arrayBG.length ; i++){
                    if(arrayBG[i] % target == 0){
                        arrB = true;
                    }else{
                        arrB = false;
                        break;
                    }
                }
                for(int i = 0 ; i < arrayAG.length ; i++){
                    if(arrayAG[i] % target == 0){
                        arrA = true;
                        break;
                    }
                }
            
                if(arrB && !arrA){     
                    answer = Math.max(answer, target);
                    return;
                } 
            }
            
        }
    }
}
