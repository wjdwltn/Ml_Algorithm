import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Binary_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr,num)).append("\n");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] arr , int num){
        int left = 0;
        int right = arr.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(num == arr[mid]){
                return 1;
            }
            else if(num < arr[mid]){
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return 0;
    }
}
