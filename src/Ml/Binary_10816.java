package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Binary_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arrs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrs);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int key = Integer.parseInt(str.nextToken());
            sb.append(UpperBound(arrs,key)-LowerBound(arrs,key)).append(' ');
        }
        System.out.println(sb);
    }

    private static int LowerBound(int[] arrs, int key){
        int min = 0;
        int max = arrs.length;

        while (min < max){
            int mid = (min + max) /2;

            if(key <= arrs[mid]){
                max = mid;
            }
            else{
                min = mid + 1;
            }
        }
        return min;
    }

    private static int UpperBound(int[] arrs, int key){
        int min = 0;
        int max = arrs.length;

        while (min < max){
            int mid = (min + max) /2;

            if(key < arrs[mid]){
                max = mid;
            }
            else{
                min = mid + 1;
            }
        }
        return min;
    }
}
