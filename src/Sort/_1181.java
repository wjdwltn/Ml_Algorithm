package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }
        String[] arr = set.toArray(new String[0]);

        Arrays.sort(arr,(o1,o2)->{
           int a = o1.length();
           int b = o2.length();
           if(a == b){
               return o1.compareTo(o2);
           }
           else{
               return a - b;
           }
        });

        for(String word : arr){
            System.out.println(word);
        }
    }
}
