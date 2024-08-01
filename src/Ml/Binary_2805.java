package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Binary_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] arrs = new int[N];
        int max = 0;
        int min = 0;
        for(int i=0; i<N; i++){
            arrs[i] = Integer.parseInt(str.nextToken());
            max = Math.max(arrs[i],max);
        }

        while(min<=max){
            int mid = (min + max)/2;
            long sum=0;
            for(int arr : arrs){
                if(arr>mid){
                    sum += (arr-mid);
                }
            }
            if(sum >= M){
                min = mid + 1;
            }
            else{
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
}
