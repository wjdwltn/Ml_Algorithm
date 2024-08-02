package Ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Binary_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arrs = new int[K];

        long min = 0;
        long max = 0;

        for(int i=0; i<K; i++){
            arrs[i] = Integer.parseInt(br.readLine());
            max = Math.max(arrs[i],max);
        }
        max++; // min이 0에서 시작이므로 합을 2로 나눈 값이 0이 되는 불상사를 막기 위함.

        while(min<max){
            long mid = (min+max)/2;
            long sum = 0;

            for(int arr : arrs){
                sum +=  (arr/mid);
            }
            if(sum < N){ // upper bound
                max = mid;
            }
            else{
                min = mid +1;
            }
        }
        System.out.println(min-1); //upper bound로 얻어진 값에서 -1
    }

    public static class Baek_1764 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            HashMap<String,Integer> map = new HashMap<>();
            List<String> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                String L_people = br.readLine();
                map.put(L_people,i);
            }

            for(int i=0; i<M; i++){
                String S_people = br.readLine();
                if(map.containsKey(S_people)){
                    list.add(S_people);
                }
            }
            Collections.sort(list);
            int count = list.size();
            System.out.println(count);
            for(String s : list){
                System.out.println(s);
            }
        }
    }
}
