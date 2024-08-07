package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i=N-1; i>=0; i--){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count=0;

        for(int i=0; i<N; i++){
            if(arr[i]<=K){
                count += K/arr[i];
                K %= arr[i];
                if(K==0) break;
            }
        }
        System.out.println(count);
    }
}
