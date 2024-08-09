package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(upper_bound(arr,0,arr.length,key)-lower_bound(arr,0,arr.length,key)).append(" ");
        }
        System.out.println(sb);
    }

    public static int upper_bound(int[]arr,int left,int right,int key){
        while(left < right){
            int mid = (left + right)/2;

            if(arr[mid] <= key){
                left = mid + 1;
            }
            else right = mid;
        }
        return right;
    }

    public static int lower_bound(int[]arr,int left,int right,int key){
        while(left < right){
            int mid = (left + right)/2;

            if(arr[mid] < key){
                left = mid + 1;
            }
            else right = mid;
        }
        return right;
    }
}
