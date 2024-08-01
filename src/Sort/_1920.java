package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int find = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr,find)).append('\n');
        }
        System.out.println(sb);

    }

    public static int binarySearch(int[] arr, int find){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = (left + right)/2;

            if(arr[mid] == find) return 1;
            else if(arr[mid] < find){
                left = mid + 1;
            }else right = mid - 1;
        }
        return 0;
    }
}
