import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Comparator;
public class Main {
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
 
        int N = Integer.parseInt(str[0]);
        
        str = br.readLine().split(" ");
        HashMap<Integer, Integer> list = new LinkedHashMap<Integer, Integer>();
        
        for (int i = 0; i < N; i++) {
            if (list.containsKey(Integer.parseInt(str[i]))) {
                list.replace(Integer.parseInt(str[i]), list.get(Integer.parseInt(str[i])) + 1);
            }
            else {
                list.put(Integer.parseInt(str[i]), 1);
            }
        }
        ArrayList<Integer> v = new ArrayList<Integer>(list.keySet());
 
        Collections.sort(v, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(list.get(b), list.get(a));
            }
        });
        Iterator<Integer> it = v.iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            for(int i=0; i<list.get(element); i++){
                System.out.print(element+" ");    
            }
            
        }
    }
}
