package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Binary_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        int[] arrs= new int[N];//기본 배열
        int[] sorted = new int[N];//정렬한 배열
        HashMap<Integer, Integer> rankMap = new HashMap<Integer,Integer>();//즁복값을 체크하고 순위를 매기기 위해

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrs[i] = sorted[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);//정렬

        int rank =0;

        for(int i : sorted){
            if(!rankMap.containsKey(i)){//rankMap에 중복된 값이 없을 경우
                rankMap.put(i,rank++);//해당 값과 순서를 map에 저장 후 rank+1을 해준다.
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int arr : arrs){
            sb.append(rankMap.get(arr)).append(' ');//rankMap에서 기존 배열의 값의 순서를 찾아준다.
        }
        System.out.println(sb);
    }
}
