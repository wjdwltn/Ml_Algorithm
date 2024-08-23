package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        //false=소수 true=소수아님
        boolean[] arr = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();

        //소수 아님
        arr[0] = true;
        arr[1] = true;


        for(int i = 2; i * i <= N; i++) {
            //소수일때
            if(!arr[i]) {
                for(int j = i * i; j <= N; j += i) {
                    arr[j] = true;
                }
            }
        }

        for(int i = M; i <= N; i++) {
            if(!arr[i])
                sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
