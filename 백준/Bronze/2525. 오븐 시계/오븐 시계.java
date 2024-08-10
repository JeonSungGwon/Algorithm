import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] time = br.readLine().split(" ");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        
        int cookTime = Integer.parseInt(br.readLine());
        
        minute += cookTime; 
        hour += minute / 60; 
        minute %= 60; 
        hour %= 24;
        
        System.out.println(hour + " " + minute);
    }
}