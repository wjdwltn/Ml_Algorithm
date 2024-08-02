package Sort;

import java.io.*;

public class _10989 {
    public static void main(String[] args) throws IOException {
        //counting sort
        //범위가 1 ≤ N ≤ 10,000,000이기 때문에 O(N)이하인 알고리즘을 설계해야함->binarySearch(O(logN)) X

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int count[] = new int[10001]; //10000보다 작거나 같은 수

        for(int i=0; i<N; i++){
            count[Integer.parseInt(br.readLine())]++; // 입력 받은 값이 count의 index가 돼서 1씩 증가시켜줌
        }
        for(int i=1; i<10001; i++){
            while(count[i]>0){
                sb.append(i).append("\n");
                count[i]--;
            }
        }
        System.out.println(sb);

    }
}
